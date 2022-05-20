public class StudentAccount extends Account {
    public StudentAccount(Bank bank, String name, double balance) {
        super(bank, name);
        super.setDeposit(balance);
        System.out.println("Student account for " + name + " Created; initial balance " + balance + "$");

    }

    @Override
    public void requestLoan(double amount) {
        if (amount > super.getBank().getMaxLoanOfStudentAccount()) {
            throw new IllegalArgumentException("Student account has loan limit");
        }
        super.requestLoan(amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > super.getBank().getMaxWithdrawOfStudentAccount()) {
            throw new IllegalArgumentException("Cannot withdraw more that 10k on student account");
        }
        super.withdraw(amount);
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
        currentDeposit += currentDeposit * super.getBank().getAccountInterestRate(Bank.AccountType.STUDENT);
        super.setDeposit(currentDeposit);

        // loan
        double currentLoan = super.getLoan();
        currentLoan += currentLoan * super.getBank().getLoanInterestRate();
        super.setLoan(currentLoan);
    }
}
