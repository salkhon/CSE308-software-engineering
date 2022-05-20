public class SavingsAccount extends Account {
    public SavingsAccount(Bank bank, String name, double balance) {
        super(bank, name);
        super.setDeposit(balance);
        System.out.println("Savings account for " + name + " Created; initial balance " + balance + "$");
    }

    @Override
    public void withdraw(double amount) {
        if (super.getDeposit() - amount < super.getBank().getMinBalanceOfSavingsAccount()) {
            throw new BankingException("Cannot have savings account balance less than 1k.");
        } else {
            super.withdraw(amount);
        }
    }

    @Override
    public void requestLoan(double amount) {
        if (amount > super.getBank().getMaxLoanOfSavingsAccount()) {
            throw new IllegalArgumentException("Savingf account account has MAX LOAN ");
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
        currentDeposit += currentDeposit * super.getBank().getAccountInterestRate(Bank.AccountType.SAVINGS) / 100;
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
