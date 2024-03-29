package BankingSystem;
public class LoanAccount extends Account {
    protected LoanAccount(Bank bank, String name, double loanAmount) {
        super(bank, name);
        super.setLoan(loanAmount);
        System.out.println("Loan account for " + name + " Created; initial loan " + loanAmount + "$");
    }

    @Override
    public void deposit(double amount) {
        super.payLoan(amount);
    }

    @Override
    public void withdraw(double amount) {
        throw new BankingException("Invalid transaction; " + this.accountStatement());
    }

    @Override
    public void requestLoan(double amount) {
        if (amount > super.getLoan() * super.getBank().getMaxLoanPercentageOfLoanAccount() / 100) {
            throw new BankingException("Invalid transaction; " + this.accountStatement());
        }

        super.requestLoan(amount);
    }

    @Override
    protected void approveLoan(double amount) {
        double currentLoan = super.getLoan();
        currentLoan += amount;

        super.setLoan(currentLoan);
    }

    @Override
    protected void incrementYear() {
        // loan
        double currentLoan = super.getLoan();
        currentLoan += currentLoan * super.getBank().getMaxLoanPercentageOfLoanAccount() / 100;
        super.setLoan(currentLoan);
    }

    @Override
    public String accountStatement() {
        return "current loan " + this.getLoan() + "$";
    }
}
