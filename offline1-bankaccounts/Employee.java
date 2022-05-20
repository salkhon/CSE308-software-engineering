
public abstract class Employee {
    private Bank bank;
    private String name;

    public Employee(Bank bank, String name) {
        this.bank = bank;
        this.name = name;
    }

    public Bank getBank() {
        return this.bank;
    }

    public double lookUp(String user) {
        if (!this.bank.getNameToAccountsMap().containsKey(user)) {
            throw new BankingException("Account does not exist");
        }

        return this.bank.getNameToAccountsMap().get(user).getDeposit();
    }

    public abstract void approveLoans();

    public abstract void setAccountInterestRate(Bank.AccountType accountType, double interestRate);

    public abstract double seeInternalFund();

    public String getName() {
        return this.name;
    }
}
