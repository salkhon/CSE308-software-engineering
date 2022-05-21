public class LoanAccount extends Account {
    public LoanAccount(Bank bank, String name, double loanAmount) {
        super(bank, name);
        super.setLoan(loanAmount);
        System.out.println("Loan account for " + name + " Created; initial loan " + loanAmount + "$");
    }

    @Override
    public void deposit(double amount) {
        super.setLoan(super.getLoan() - amount);
        super.getBank().changeInternalFund(amount);
        System.out.println(amount + "$ deposited; current loan " + super.getLoan());
    }

    @Override
    public void withdraw(double amount) {
        throw new BankingException("Cannot withdraw from loan account.");
    }

    @Override
    public void requestLoan(double amount) {
        if (amount > super.getLoan() * super.getBank().getMaxLoanPercentageOfLoanAccount() / 100) {
            throw new BankingException("Loan account has MAX LOAN percentage");
        }

        super.requestLoan(amount);
    }

    @Override
    public void approveLoan(double amount) {
        double currentLoan = super.getLoan();
        currentLoan += amount;

        super.setLoan(currentLoan);
    }

    @Override
    public void incrementYear() {
        // loan
        double currentLoan = super.getLoan();
        currentLoan += currentLoan * super.getBank().getMaxLoanPercentageOfLoanAccount() / 100;
        super.setLoan(currentLoan);
    }
}
