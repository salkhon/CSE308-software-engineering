public abstract class Account {
    private String name;
    private Bank bank;
    private int yearCreated;

    private double deposit;
    private double loan;

    // loan account effective loan is: loan - deposit.

    public Account(Bank bank, String name) {
        this.bank = bank;
        this.name = name;
        this.yearCreated = bank.getCurrentYear();
    }

    public void deposit(double amount) {
        this.deposit += amount;
        System.out.println(amount + "$ deposited; current balance " + this.deposit);
    }

    public void withdraw(double amount) {
        if (this.deposit - amount < 0) {
            throw new BankingException("Cannot withdraw more than balance");
        } else {
            this.deposit -= amount;
            System.out.println(amount + "$ withdrawn; current balance " + this.deposit);
        }
    }

    public void requestLoan(double amount) {
        this.bank.requestLoan(this, amount);
    }

    public abstract void approveLoan(double amount);

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
}
