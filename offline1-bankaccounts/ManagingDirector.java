public class ManagingDirector extends Employee {
    public ManagingDirector(Bank bank, String name) {
        super(bank, name);
    }

    public void approveLoans() {
        super.getBank().approveLoans();
    }

    @Override
    public void setAccountInterestRate(Bank.AccountType accountType, double interestRate) {
        super.getBank().setAccountInterestRate(accountType, interestRate);
    }

    public double getInternalFund() {
        return 0;
    }

    @Override
    public double seeInternalFund() {
        return super.getBank().getInternalFund();
    }
}
