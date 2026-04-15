package bank.core;

public class SampleBankAccount {

    public static void viewAccount() {

        BankAccount account = new BankAccount();

        // ✅ pakai getter
        System.out.println(account.getAccountNumber());
        System.out.println(account.getBalance());

        // ❌ JANGAN tampilkan password

        account.deposit(1000);

        // ❌ jangan panggil calculateInterest langsung
        // account.calculateInterest();

        // ✅ pakai wrapper
        account.addInterest();
    }
}
