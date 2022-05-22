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
        // throw new BankingException("Officer can't change interest rates");
        throw new BankingException("You don't have permission for this operation");
    }

    @Override
    public double seeInternalFund() {
        // throw new BankingException("Officer can't see internal fund");
        throw new BankingException("You don't have permission for this operation");
    }
}
