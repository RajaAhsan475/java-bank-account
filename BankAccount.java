import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String owner;
    private double balance;
    private List<String> transactions;

    public BankAccount(String owner, double initialBalance) {
        if (initialBalance < 0) throw new IllegalArgumentException("Initial balance cannot be negative");
        this.owner = owner;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add(String.format("Account opened with %.2f", initialBalance));
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive");
        balance += amount;
        transactions.add(String.format("Deposit: +%.2f | Balance: %.2f", amount, balance));
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive");
        if (amount > balance) throw new IllegalStateException("Insufficient funds");
        balance -= amount;
        transactions.add(String.format("Withdrawal: -%.2f | Balance: %.2f", amount, balance));
    }

    public double getBalance() {
        return balance;
    }

    public void printStatement() {
        System.out.println("\n=== Statement for " + owner + " ===");
        for (String t : transactions) {
            System.out.println("  " + t);
        }
        System.out.printf("Current Balance: %.2f%n", balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Ahsan", 1000.00);
        account.deposit(500.00);
        account.withdraw(200.00);
        account.deposit(150.00);
        account.withdraw(75.50);
        account.printStatement();

        try {
            account.withdraw(5000.00);
        } catch (IllegalStateException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}
