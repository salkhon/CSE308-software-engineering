public abstract class Account {
    private String name;
    private Bank bank;
    private int yearCreated;

    private double deposit;
    private double loan;

    // loan account effective loan is: loan - deposit.

    protected Account(Bank bank, String name) {
        this.bank = bank;
        this.name = name;
        this.yearCreated = bank.getCurrentYear();
    }

    public void deposit(double amount) {
        this.deposit += amount;
        this.bank.changeInternalFund(amount);
        System.out.println(amount + "$ deposited; " + this.accountStatement());
    }

    public void withdraw(double amount) {
        if (this.deposit - amount < 0) {
            throw new BankingException("Cannot withdraw more than balance");
        } else {
            this.deposit -= amount;
            this.bank.changeInternalFund(-amount);
            System.out.println(amount + "$ withdrawn; " + this.accountStatement());
        }
    }

    public void requestLoan(double amount) {
        this.bank.requestLoan(this, amount);
    }

    public abstract void approveLoan(double amount);

    public void payLoan(double amount) {
        double payableAmount = this.loan > amount ? amount : this.loan;

        this.loan -= payableAmount;
        System.out.println("Loan repayed by " + payableAmount + "$. " + this.accountStatement());

        double leftoverAmount = amount - payableAmount;

        if (leftoverAmount > 0) {
            this.deposit(amount);
        }

        this.bank.changeInternalFund(amount);
    }

    public double getLoan() {
        return this.loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public double getDeposit() {
        return this.deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public abstract void incrementYear();

    public String getName() {
        return this.name;
    }

    public Bank getBank() {
        return this.bank;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public int getYearCreated() {
        return this.yearCreated;
    }

    public String accountStatement() {
        String print = "Current balance: " + this.deposit + "$";
        if (this.loan > 0) {
            print += ", loan " + this.loan + "$";
        }
        return print;
    }
}
