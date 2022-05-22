public class StudentAccount extends Account {
    protected StudentAccount(Bank bank, String name, double balance) {
        super(bank, name);
        super.setDeposit(balance);
        System.out.println("Student account for " + name + " Created; initial balance " + balance + "$");

    }

    @Override
    public void requestLoan(double amount) {
        if (amount > super.getBank().getMaxLoanOfStudentAccount()) {
            // throw new BankingException("Student account has loan limit");
            throw new BankingException("Invalid transaction; " + this.accountStatement());
        }
        super.requestLoan(amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > super.getBank().getMaxWithdrawOfStudentAccount()) {
            // throw new BankingException("Cannot withdraw more that 10k on student account");
            throw new BankingException("Invalid transaction; " + this.accountStatement());
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
        double interestDeposit = currentDeposit * super.getBank().getAccountInterestRate(Bank.AccountType.STUDENT)
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
