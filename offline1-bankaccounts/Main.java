import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Scanner scanner = new Scanner(System.in);

        Account currentAccount = null;
        Employee currentEmployee = null;

        while (true) {
            try {
                String input = "";
                String option = "";
                String[] inputWords;

                option = scanner.next("[a-zA-Z]+");
                input = scanner.nextLine().trim();

                if (option.equals("Create") && currentAccount == null) {
                    inputWords = input.split(" ");
                    String name = inputWords[0], type = inputWords[1];
                    double initDeposit = Double.parseDouble(inputWords[2]);

                    try {
                        if (type.equals("Savings")) {
                            currentAccount = bank.createAccount(Bank.AccountType.SAVINGS, name, initDeposit);
                        } else if (type.equals("Student")) {
                            currentAccount = bank.createAccount(Bank.AccountType.STUDENT, name, initDeposit);
                        } else if (type.equals("Loan")) {
                            currentAccount = bank.createAccount(Bank.AccountType.LOAN, name, initDeposit);
                        } else if (type.equals("FixedDeposit")) {
                            currentAccount = bank.createAccount(Bank.AccountType.FIXED_DEPOSIT, name, initDeposit);
                        }
                    } catch (BankingException e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                } else if (option.equals("Deposit") && currentAccount != null) {
                    double amount = Double.parseDouble(input);
                    try {
                        currentAccount.deposit(amount);
                    } catch (BankingException e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                } else if (option.equals("Pay") && currentAccount != null) {
                    double amount = Double.parseDouble(input);
                    try {
                        currentAccount.payLoan(amount);
                    } catch (BankingException e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                } else if (option.equals("Withdraw") && currentAccount != null) {
                    double amount = Double.parseDouble(input.replaceAll(",", ""));
                    try {
                        currentAccount.withdraw(amount);
                    } catch (BankingException e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                } else if (option.equals("Query") && currentAccount != null) {
                    if (currentAccount.getLoan() > 0) {
                        System.out.println("Current balance " + currentAccount.getDeposit() + ", loan "
                                + currentAccount.getLoan() + "$");
                    } else {
                        System.out.println("Current balance " + currentAccount.getDeposit());
                    }
                } else if (option.equals("Request") && currentAccount != null) {
                    double amount = Double.parseDouble(input);
                    currentAccount.requestLoan(amount);
                } else if (option.equals("Close") && (currentAccount != null || currentEmployee != null)) {
                    if (currentAccount != null) {
                        System.out.println("Transaction Closed for " + currentAccount.getName());
                        currentAccount = null;
                    } else {
                        System.out.println("Operations for " + currentEmployee.getName() + " closed");
                        currentEmployee = null;
                    }
                } else if (option.equals("Open") && currentEmployee == null && currentAccount == null) {
                    if (bank.getAccountByName(input) != null) {
                        currentAccount = bank.getAccountByName(input);
                        System.out.println("Welcome back " + currentAccount.getName());
                    } else if (bank.getEmployeeByName(input) != null) {
                        currentEmployee = bank.getEmployeeByName(input);
                        if (bank.areLoanApprovalsPending()) {
                            System.out.println(currentEmployee.getName() + " active. There are loan approvals pending");
                        } else {
                            System.out.println(currentEmployee.getName() + " active.");
                        }
                    }
                } else if (option.equals("Approve") && currentEmployee != null) {
                    try {
                        currentEmployee.approveLoans();
                    } catch (BankingException e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                } else if (option.equals("Change") && currentEmployee != null) {
                    inputWords = input.split(" ");
                    String accountType = inputWords[0];
                    double interestRate = Double.parseDouble(inputWords[1]);
                    Bank.AccountType bankAccountType = null;

                    if (accountType.equals("Savings")) {
                        bankAccountType = Bank.AccountType.SAVINGS;
                    } else if (accountType.equals("Student")) {
                        bankAccountType = Bank.AccountType.STUDENT;
                    } else if (accountType.equals("FixedDeposit")) {
                        bankAccountType = Bank.AccountType.FIXED_DEPOSIT;
                    } else {
                        continue;
                    }

                    try {
                        currentEmployee.setAccountInterestRate(bankAccountType, interestRate);
                    } catch (BankingException e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                } else if (option.equals("Lookup") && currentEmployee != null) {
                    Account account = bank.getAccountByName(input);
                    if (account == null) {
                        throw new BankingException("No account by that name");
                    }

                    if (account.getLoan() > 0) {
                        System.out.println(input + "'s current balance " + bank.getAccountDeposit(input)
                                + "; current loan " + account.getLoan() + "$");
                    } else {
                        System.out.println(input + "'s current balance " + bank.getAccountDeposit(input));
                    }
                } else if (option.equals("See") && currentEmployee != null) {
                    try {
                        System.out.println("Internal fund " + currentEmployee.seeInternalFund());
                    } catch (BankingException e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                } else if (option.equals("INC") && currentAccount == null && currentEmployee == null) {
                    bank.incrementYear();
                } else if (option.equals("Quit")) {
                    break;
                } else {
                    System.out.println("You don't have permission for this operation");
                }
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }

        scanner.close();
    }

}