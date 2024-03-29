package BankingSystem;

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
    private double minDepositOfFixedDepositAccount;
    private double minBalanceOfSavingsAccount;

    private double maxLoanOfSavingsAccount;
    private double maxLoanOfStudentAccount;
    private double maxLoanOfFixedDepositAccount;
    public double maxLoanPercentageOfLoanAccount;

    private double serviceCharge;

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
        System.out.println("Bank Created; MD, S1, S2, C1, C3, C4, C5 created");
    }

    private void setDefaultAccountParameters() {
        this.maxWithdrawOfStudentAccount = 10000;
        this.minDepositOfFixedDepositAccount = 50000;
        this.minBalanceOfSavingsAccount = 1000;

        this.maxLoanOfSavingsAccount = 10000;
        this.maxLoanOfStudentAccount = 1000;
        this.maxLoanOfFixedDepositAccount = 100000;
        this.maxLoanPercentageOfLoanAccount = 5;

        this.serviceCharge = 500;

        this.accountTypeToInterestRateMap.put(AccountType.SAVINGS, 10.0);
        this.accountTypeToInterestRateMap.put(AccountType.STUDENT, 5.0);
        this.accountTypeToInterestRateMap.put(AccountType.FIXED_DEPOSIT, 15.0);
        this.loanInterestRate = 10;
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
            throw new BankingException("Account with that name already exists");
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
                throw new BankingException("Invalid transaction.");
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

    public void incrementYear() {
        for (Account account : this.nameToAccountsMap.values()) {
            account.incrementYear();
        }
        this.currentYear++;
        System.out.println("1 year passed");
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    protected void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public double getMinBalanceOfSavingsAccount() {
        return minBalanceOfSavingsAccount;
    }

    protected void setMinBalanceOfSavingsAccount(double minBalanceOfSavingsAccount) {
        this.minBalanceOfSavingsAccount = minBalanceOfSavingsAccount;
    }

    public double getMinDepositOfFixedDepositAccount() {
        return minDepositOfFixedDepositAccount;
    }

    protected void setMinDepositOfFixedDepositAccount(double minDepositOfFixedDepositAccount) {
        this.minDepositOfFixedDepositAccount = minDepositOfFixedDepositAccount;
    }

    public double getAccountInterestRate(AccountType accountType) {
        return this.accountTypeToInterestRateMap.get(accountType);
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

    protected void setMaxLoanPercentageOfLoanAccount(double maxLoanPercentageOfLoanAccount) {
        this.maxLoanPercentageOfLoanAccount = maxLoanPercentageOfLoanAccount;
    }

    public Map<AccountType, Double> getAccountTypeToInterestRateMap() {
        return accountTypeToInterestRateMap;
    }

    protected void setAccountTypeToInterestRateMap(Map<AccountType, Double> accountTypeToInterestRateMap) {
        this.accountTypeToInterestRateMap = accountTypeToInterestRateMap;
    }

    public double getInternalFund() {
        return internalFund;
    }

    protected void setInternalFund(double internalFund) {
        this.internalFund = internalFund;
    }

    public double getMaxLoanOfSavingsAccount() {
        return maxLoanOfSavingsAccount;
    }

    protected void setMaxLoanOfSavingsAccount(double maxLoanOfSavingsAccount) {
        this.maxLoanOfSavingsAccount = maxLoanOfSavingsAccount;
    }

    public double getMaxLoanOfStudentAccount() {
        return maxLoanOfStudentAccount;
    }

    protected void setMaxLoanOfStudentAccount(double maxLoanOfStudentAccount) {
        this.maxLoanOfStudentAccount = maxLoanOfStudentAccount;
    }

    public double getMaxLoanOfFixedDepositAccount() {
        return maxLoanOfFixedDepositAccount;
    }

    protected void setMaxLoanOfFixedDepositAccount(double maxLoanOfFixedDepositAccount) {
        this.maxLoanOfFixedDepositAccount = maxLoanOfFixedDepositAccount;
    }

    public double getMaxWithdrawOfStudentAccount() {
        return maxWithdrawOfStudentAccount;
    }

    protected void setMaxWithdrawOfStudentAccount(double maxWithdrawOfStudentAccount) {
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

    protected void approveLoans() {
        StringBuilder stringBuilder = new StringBuilder("Loan for");

        for (Loan loan : this.loanRequests) {
            Account account = this.nameToAccountsMap.get(loan.name);
            account.approveLoan(loan.loan);

            stringBuilder.append(" " + account.getName() + ",");
        }
        stringBuilder.replace(stringBuilder.lastIndexOf(","), stringBuilder.lastIndexOf(",") + 1, "");
        this.loanRequests.clear();

        stringBuilder.append(" approved");
        System.out.println(stringBuilder.toString());
    }

    protected void changeInternalFund(double amount) {
        this.internalFund += amount;
    }

    protected void setAccountInterestRate(AccountType accountType, double interestRate) {
        this.accountTypeToInterestRateMap.put(accountType, interestRate);
        System.out.println(accountType.toString() + " interest rate changed to " + interestRate);
    }

    protected void setLoanInterestRate(double loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
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
