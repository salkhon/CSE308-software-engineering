public class FixedDepositAccount extends Account {
    public FixedDepositAccount(Bank bank, String name, double balance) {
        super(bank, name);
        super.setDeposit(balance);
        System.out.println("Fixed Deposit account for " + name + " Created; initial balance " + balance + "$");
    }

    @Override
    public void deposit(double amount) {
        if (amount < super.getBank().getMinDepositOfFixedDepositAccount()) {
            throw new BankingException("Fixed Deposit Accounts need to be deposited with larger than 50k.");
        } else {
            super.deposit(amount);
            super.setYearCreated(super.getBank().getCurrentYear());
        }
    }

    @Override
    public void withdraw(double amount) {
        if (super.getBank().getCurrentYear() < super.getYearCreated() + 1) {
            throw new BankingException("FDR maturity not reached");
        }

        double currentDeposit = super.getDeposit();
        currentDeposit -= amount;
        super.setDeposit(currentDeposit);
    }

    @Override
    public void requestLoan(double amount) {
        if (amount > super.getBank().getMaxLoanOfFixedDepositAccount()) {
            throw new BankingException("Savings account has MAX LOAN of 100000");
        }

        super.requestLoan(amount);
    }

    @Override
    public void approveLoan(double amount) {
        double currentDeposit = super.getDeposit();
        currentDeposit += amount;

        double currentLoan = super.getLoan();
        currentLoan += amount;

        super.setDeposit(currentDeposit);
        super.setLoan(currentLoan);
    }

    @Override
    public void incrementYear() {
        // deposit
        double currentDeposit = super.getDeposit();
        currentDeposit += currentDeposit * super.getBank().getAccountInterestRate(Bank.AccountType.FIXED_DEPOSIT) / 100;
        super.setDeposit(currentDeposit);

        // loan
        double currentLoan = super.getLoan();
        currentLoan += currentLoan * super.getBank().getLoanInterestRate() / 100;
        super.setLoan(currentLoan);

        // service charge
        currentDeposit -= super.getBank().getServiceCharge();
        if (currentDeposit < 0) {
            // the money you don't have will be loaned
            super.setLoan(super.getLoan() + (-currentDeposit));
        }
    }
}
