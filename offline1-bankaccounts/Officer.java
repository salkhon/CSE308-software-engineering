public class Officer extends Employee {
    public Officer(Bank bank, String name) {
        super(bank, name);
    }

    @Override
    public void approveLoans() {
        super.getBank().approveLoans();
    }

    @Override
    public void setAccountInterestRate(Bank.AccountType accountType, double interestRate) {
        throw new BankingException("Officer can't change interest rates");
    }

    @Override
    public double seeInternalFund() {
        throw new BankingException("Officer can't see internal fund");
    }
}
