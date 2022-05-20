public class Cashier extends Employee {
    public Cashier(Bank bank, String name) {
        super(bank, name);
    }

    @Override
    public void approveLoans() {
        throw new IllegalArgumentException("Cashier can't approve loans");
    }

    @Override
    public void setAccountInterestRate(Bank.AccountType accountType, double interestRate) {
        throw new IllegalArgumentException("Cashier can't change interest rates");
    }

    @Override
    public double seeInternalFund() {
        throw new IllegalArgumentException("Cashier can't see internal fund");
    }
}