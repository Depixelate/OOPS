package Ex5Exceptions;

import java.util.Scanner;
import java.util.Arrays;

class PANRequiredException extends Exception{
    public String toString() {
        return "Error!, Deposits of 25,000 require a PAN!";
    }
}

class MinBalRequiredException extends Exception{
    private double minBal;
    public MinBalRequiredException(double minBal) {
        this.minBal = minBal;
    }
    public String toString() {
        return String.format("Error!, Balance is less than the minimum, %f", minBal);
    }
}

class InsufficientBalanceException extends Exception{
    public String toString() {
        return "Error!, You are trying to withdraw more money than exists in your bank account!";
    }
}

class AccountNotFoundException extends Exception{
    public String toString() {
        return "Error!, An Account with This number doesn't exist!";
    }
}

class PANFormatMismatchException extends Exception{
    public String toString() {
        return "Error!, the given PAN has an incorrect format!";
    }
}

class BranchNotFoundException extends Exception{
    public String toString() {
        return "Error!, the Branch Given doesn't exist!";
    }
}

class BankAccount {
    private String name;
    private String acct_num;
    private String branch;
    private double balance;
    private String PAN_num;

    final static String[] validAcctNums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    final static String[] validBranches = {"chennai", "mumbai", "dehli", "bangalore", "hyderabad"};

    public static void printf(String fmt, Object... args) {
        System.out.printf(fmt, args);
    }

    private static boolean isValidPAN(String num) {
        if(num.length() != 10) return false;
        var panArr = num.toCharArray();
        for(int i = 0; i < 5; i++) {
            if(!Character.isLetter(panArr[i])) return false;
        }
        for(int i = 5; i < 9; i++) {
            if(!Character.isDigit(panArr[i])) return false;
        }
        if(!Character.isLetter(panArr[9])) return false;
        return true;
    }

    private void display() {
        printf("BANK ACCOUNT START: \n");
        printf("Name: %s\n",name);
        printf("Account Number: %s\n", acct_num);
        printf("Branch: %s\n", branch);
        printf("Balance: %f\n", balance);
        printf("PAN Number: %s\n", PAN_num);
        printf("BANK ACCOUNT END: \n");
    }

    public BankAccount(String name, String acct_num, String branch, double balance, String PAN_num) throws BranchNotFoundException {
        this.name = name;
        this.acct_num = acct_num;
        this.branch = branch.toLowerCase().trim();
        if(!Arrays.asList(validBranches).contains(this.branch)) {
            throw new BranchNotFoundException();
        }
        this.balance = balance;
        this.PAN_num = PAN_num;
    }

    public void deposit(double amt) throws AccountNotFoundException, PANRequiredException, PANFormatMismatchException {
        if(amt > 25000 && PAN_num.isBlank()) {
            throw new PANRequiredException();
        }

        if(!PAN_num.isBlank() && !isValidPAN(PAN_num)) {
            throw new PANFormatMismatchException();
        }

        balance += amt;

        if(!Arrays.asList(validAcctNums).contains(acct_num)) {
            throw new AccountNotFoundException();    
        } else {
            display();
        }
    }

    public void withdraw(double amt) throws AccountNotFoundException, InsufficientBalanceException, MinBalRequiredException{
        final double MIN_BALANCE = 1000;

        if(amt > balance) {
            throw new InsufficientBalanceException();
        }

        balance -= amt;

        if(!Arrays.asList(validAcctNums).contains(acct_num)) {
            throw new AccountNotFoundException();    
        } else {
            display();
        }

        if(balance < MIN_BALANCE) {
            throw new MinBalRequiredException(MIN_BALANCE);
        }

    }

    public void setPAN_num(String PAN_num) {
        this.PAN_num = PAN_num;
    }
}

class Main {
    private final static Scanner sc = new Scanner(System.in);
    public static void handleSetPAN(BankAccount acct) {
        BankAccount.printf("Enter good PAN Number: ");
        var new_PAN_num = sc.nextLine();
        acct.setPAN_num(new_PAN_num);
    }
    public static void main(String[] args) {
        outerLoop:
        while(true) {
            try {
                BankAccount.printf("Enter Your name: ");
                var name = sc.nextLine();
                BankAccount.printf("Enter Account Number: ");
                var acct_num = sc.nextLine();
                BankAccount.printf("Enter the branch: ");
                var branch = sc.nextLine();
                BankAccount.printf("Enter balance: ");
                var balance = Double.parseDouble(sc.nextLine());
                BankAccount.printf("Enter PAN: ");
                var PAN_num = sc.nextLine();
                var acct = new BankAccount(name, acct_num, branch, balance, PAN_num);
                while(true) {
                    try {
                        double amt_deposit = 0;
                        try {
                            BankAccount.printf("What do you want to do?\n"
                            +"1. Deposit Money.\n"
                            +"2. Withdraw Money.\n"
                            +"3. Set PAN.\n"
                            +"4. Quit\n"
                            +"Enter your option: ");
                            var op = sc.nextLine();
                            switch (op) {
                                case "1":
                                    BankAccount.printf("Enter the amount to deposit: ");
                                    amt_deposit = Double.parseDouble(sc.nextLine());
                                    acct.deposit(amt_deposit);
                                    break;
                                case "2":
                                    BankAccount.printf("Enter the amount to withdraw: ");
                                    double amt_withdraw = Double.parseDouble(sc.nextLine());
                                    acct.withdraw(amt_withdraw);
                                    break;
                                case "3":
                                    handleSetPAN(acct);
                                    break;
                                default:
                                    break outerLoop;
                            }
                        } catch(PANRequiredException e) {
                            BankAccount.printf("An Exception was Thrown: %s\n", e);
                            handleSetPAN(acct);
                            acct.deposit(amt_deposit);
                        }
                    } catch(Exception e) {
                        BankAccount.printf("An Exception was thrown: %s\n", e);
                        BankAccount.printf("Continuing...\n");
                    }
                }
            } catch(BranchNotFoundException e) {
                BankAccount.printf("An exception was thrown: %s\n", e);
                BankAccount.printf("Restarting...\n");
            }
        }
        sc.close();
    }
}