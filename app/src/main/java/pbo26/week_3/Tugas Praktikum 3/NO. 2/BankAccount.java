package bank.core;

public class BankAccount {

    private String accountNumber;
    private double balance;
    private String password;

    public BankAccount() {
        this.accountNumber = "ACC001";
        this.balance = 0;
        this.password = "123456";
    }

    // ===== GETTER =====
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // ❌ password TIDAK boleh ada getter

    // ===== DEPOSIT =====
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit berhasil");
        } else {
            System.out.println("Nominal tidak valid");
        }
    }

    // ===== METHOD PRIVATE =====
    private void calculateInterest() {
        balance += balance * 0.05;
        System.out.println("Bunga ditambahkan");
    }

    // ===== WRAPPER (biar bisa dipanggil) =====
    public void addInterest() {
        calculateInterest();
    }
}