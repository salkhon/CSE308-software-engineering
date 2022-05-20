import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Bank {
    public static enum AccountType {
        SAVINGS, STUDENT, LOAN, FIXED_DEPOSIT
    }

    private Map<AccountType, Double> accountTypeToInterestRateMap;
    private Map<String, Account> nameToAccountsMap;
    private Map<String, Employee> nameToEmployeeMap;

    private double internalFund;
    private int currentYear;

    private double maxWithdrawOfStudentAccount;

    private double maxLoanOfSavingsAccount;
    private double maxLoanOfStudentAccount;
    private double maxLoanOfFixedDepositAccount;
    public double maxLoanPercentageOfLoanAccount;

    private double loanInterestRate;
    private List<Loan> loanRequests;

    public Bank() {
        this.accountTypeToInterestRateMap = new HashMap<>();
        this.nameToAccountsMap = new HashMap<>();
        this.nameToEmployeeMap = new HashMap<>();

        this.internalFund = 1000000;
        this.currentYear = 0;

        setDefaultAccountParameters();

        this.loanRequests = new ArrayList<>();

        this.createDefaultEmployees();
        System.out.println("Bank Created; M D, S1, S2, C1, C3, C4, C5 created");
    }

    private void setDefaultAccountParameters() {
        this.maxWithdrawOfStudentAccount = 10000;

        this.maxLoanOfSavingsAccount = 10000;
        this.maxLoanOfStudentAccount = 1000;
        this.maxLoanOfFixedDepositAccount = 100000;
        this.maxLoanPercentageOfLoanAccount = 0.05;

        this.accountTypeToInterestRateMap.put(AccountType.SAVINGS, 0.1);
        this.accountTypeToInterestRateMap.put(AccountType.STUDENT, 0.05);
        this.accountTypeToInterestRateMap.put(AccountType.FIXED_DEPOSIT, 0.15);
        this.loanInterestRate = 0.1;
    }

    private void createDefaultEmployees() {
        nameToEmployeeMap.put("MD", new ManagingDirector(this, "MD"));
        nameToEmployeeMap.put("S1", new Officer(this, "S1"));
        nameToEmployeeMap.put("S2", new Officer(this, "S2"));
        nameToEmployeeMap.put("C1", new Cashier(this, "C1"));
        nameToEmployeeMap.put("C2", new Cashier(this, "C2"));
        nameToEmployeeMap.put("C3", new Cashier(this, "C3"));
        nameToEmployeeMap.put("C4", new Cashier(this, "C4"));
        nameToEmployeeMap.put("C5", new Cashier(this, "C5"));
    }

    public Account createAccount(AccountType accountType, String name, double initialParam) {
        if (this.nameToAccountsMap.containsKey(name)) {
            throw new IllegalArgumentException("Account with that name already exists");
        }

        Account account;
        if (accountType == AccountType.SAVINGS) {
            account = new SavingsAccount(this, name, initialParam);
        } else if (accountType == AccountType.STUDENT) {
            account = new StudentAccount(this, name, initialParam);
        } else if (accountType == AccountType.LOAN) {
            account = new LoanAccount(this, name, initialParam);
        } else {
            if (initialParam < 100000) {
                throw new IllegalArgumentException("FD Account must have higher init balance");
            } else {
                account = new FixedDepositAccount(this, name, initialParam);
            }
        }

        this.nameToAccountsMap.put(name, account);

        return account;
    }

    public Employee createEmployee() {
        return null;
    }

    protected Map<String, Account> getNameToAccountsMap() {
        return this.nameToAccountsMap;
    }

    protected void setNameToAccountsMap(Map<String, Account> nameToAccountsMap) {
        this.nameToAccountsMap = nameToAccountsMap;
    }

    protected void requestLoan(Account account, double amount) {
        this.loanRequests.add(new Loan(account.getName(), amount));
        System.out.println("Loan request successful, sent for approval");
    }

    protected void incrementYear() {
        for (Account account : this.nameToAccountsMap.values()) {
            account.incrementYear();
        }
        this.currentYear++;
        System.out.println("1 year passed");
    }

    protected void approveLoans() {
        StringBuilder stringBuilder = new StringBuilder("Loans for");

        for (Loan loan : this.loanRequests) {
            Account account = this.nameToAccountsMap.get(loan.name);
            account.approveLoan(loan.loan);

            stringBuilder.append(" " + account.getName() + ",");
        }
        this.loanRequests.clear();

        stringBuilder.append(" approved");
        System.out.println(stringBuilder.toString());
    }

    protected void setAccountInterestRate(AccountType accountType, double interestRate) {
        this.accountTypeToInterestRateMap.put(accountType, interestRate);
    }

    public double getAccountInterestRate(AccountType accountType) {
        return this.accountTypeToInterestRateMap.get(accountType);
    }

    protected void setLoanInterestRate(double loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
    }

    public double getLoanInterestRate() {
        return loanInterestRate;
    }

    public int getCurrentYear() {
        return this.currentYear;
    }

    public double getMaxLoanPercentageOfLoanAccount() {
        return maxLoanPercentageOfLoanAccount;
    }

    public void setMaxLoanPercentageOfLoanAccount(double maxLoanPercentageOfLoanAccount) {
        this.maxLoanPercentageOfLoanAccount = maxLoanPercentageOfLoanAccount;
    }

    public Map<AccountType, Double> getAccountTypeToInterestRateMap() {
        return accountTypeToInterestRateMap;
    }

    public void setAccountTypeToInterestRateMap(Map<AccountType, Double> accountTypeToInterestRateMap) {
        this.accountTypeToInterestRateMap = accountTypeToInterestRateMap;
    }

    public double getInternalFund() {
        return internalFund;
    }

    public void setInternalFund(double internalFund) {
        this.internalFund = internalFund;
    }

    public double getMaxLoanOfSavingsAccount() {
        return maxLoanOfSavingsAccount;
    }

    public void setMaxLoanOfSavingsAccount(double maxLoanOfSavingsAccount) {
        this.maxLoanOfSavingsAccount = maxLoanOfSavingsAccount;
    }

    public double getMaxLoanOfStudentAccount() {
        return maxLoanOfStudentAccount;
    }

    public void setMaxLoanOfStudentAccount(double maxLoanOfStudentAccount) {
        this.maxLoanOfStudentAccount = maxLoanOfStudentAccount;
    }

    public double getMaxLoanOfFixedDepositAccount() {
        return maxLoanOfFixedDepositAccount;
    }

    public void setMaxLoanOfFixedDepositAccount(double maxLoanOfFixedDepositAccount) {
        this.maxLoanOfFixedDepositAccount = maxLoanOfFixedDepositAccount;
    }

    public double getMaxWithdrawOfStudentAccount() {
        return maxWithdrawOfStudentAccount;
    }

    public void setMaxWithdrawOfStudentAccount(double maxWithdrawOfStudentAccount) {
        this.maxWithdrawOfStudentAccount = maxWithdrawOfStudentAccount;
    }

    public double getAccountDeposit(String name) {
        return this.nameToAccountsMap.get(name).getDeposit();
    }

    public Account getAccountByName(String name) {
        return this.nameToAccountsMap.get(name);
    }

    public Employee getEmployeeByName(String name) {
        return this.nameToEmployeeMap.get(name);
    }

    public boolean areLoanApprovalsPending() {
        return this.loanRequests.size() != 0;
    }

    protected static class Loan {
        public String name;
        public double loan;

        public Loan(String name, double loan) {
            this.name = name;
            this.loan = loan;
        }
    }
}
