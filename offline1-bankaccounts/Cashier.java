public class Cashier extends Employee {
    public Cashier(Bank bank, String name) {
        super(bank, name);
    }

    @Override
    public void approveLoans() {
        // throw new BankingException("Cashier can't approve loans");
        throw new BankingException("You don't have permission for this operation");
    }

    @Override
    public void setAccountInterestRate(Bank.AccountType accountType, double interestRate) {
        // throw new BankingException("Cashier can't change interest rates");
        throw new BankingException("You don't have permission for this operation");
    }

    @Override
    public double seeInternalFund() {
        // throw new BankingException("Cashier can't see internal fund");
        throw new BankingException("You don't have permission for this operation");
    }
}
