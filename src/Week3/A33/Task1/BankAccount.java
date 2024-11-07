package Week3.A33.Task1;

public class BankAccount {

    private static int accCount = 0;
    private int balance;
    private int accountNumber;


    public BankAccount(int balance) {
        this.accountNumber = accCount + 1;
        this.balance = balance;
        accCount++;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void deposit(int money) {
        this.balance += money;
    }

    public void withdraw(int money) {
        this.balance -= money;
    }

    public int getBalance() {
        return this.balance;
    }

    public static int getTotalAccounts() {
        return accCount;
    }


    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        account1.deposit(500);
        account2.withdraw(800);

        System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());

        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }
}
