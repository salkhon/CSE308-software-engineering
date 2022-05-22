package BankingSystem;
public class FixedDepositAccount extends Account {
    protected FixedDepositAccount(Bank bank, String name, double balance) {
        super(bank, name);
        super.setDeposit(balance);
        System.out.println("Fixed Deposit account for " + name + " Created; initial balance " + balance + "$");
    }

    @Override
    public void deposit(double amount) {
        if (amount < super.getBank().getMinDepositOfFixedDepositAccount()) {
            throw new BankingException("Invalid transaction; " + this.accountStatement());
        } else {
            super.deposit(amount);
            super.setYearCreated(super.getBank().getCurrentYear());
        }
    }

    @Override
    public void withdraw(double amount) {
        if (super.getBank().getCurrentYear() < super.getYearCreated() + 1) {
            throw new BankingException("Invalid transaction; " + this.accountStatement());
        }

        double currentDeposit = super.getDeposit();
        currentDeposit -= amount;
        super.setDeposit(currentDeposit);
    }

    @Override
    public void requestLoan(double amount) {
        if (amount > super.getBank().getMaxLoanOfFixedDepositAccount()) {
            throw new BankingException("Invalid transaction; " + this.accountStatement());
        }

        super.requestLoan(amount);
    }

    @Override
    protected void approveLoan(double amount) {
        double currentDeposit = super.getDeposit();
        currentDeposit += amount;

        double currentLoan = super.getLoan();
        currentLoan += amount;

        super.setDeposit(currentDeposit);
        super.setLoan(currentLoan);
    }

    @Override
    protected void incrementYear() {
        // deposit
        double currentDeposit = super.getDeposit();
        double interestDeposit = currentDeposit * super.getBank().getAccountInterestRate(Bank.AccountType.FIXED_DEPOSIT)
                / 100;
        currentDeposit += interestDeposit;
        super.setDeposit(currentDeposit);

        // loan
        double currentLoan = super.getLoan();
        currentLoan += currentLoan * super.getBank().getLoanInterestRate() / 100;
        super.setLoan(currentLoan);

        // service charge
        double serviceCharge = super.getBank().getServiceCharge();
        double deductibleServiceCharge;
        if (currentDeposit > serviceCharge) {
            currentDeposit -= serviceCharge;
            super.setDeposit(currentDeposit);

            deductibleServiceCharge = serviceCharge;
        } else {
            super.setLoan(super.getLoan() + (serviceCharge - currentDeposit));

            deductibleServiceCharge = currentDeposit;
        }

        // bank internal fund
        super.getBank().changeInternalFund(-interestDeposit + deductibleServiceCharge);
    }
}
