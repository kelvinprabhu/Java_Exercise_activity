// package BANKS;

class SavingsAccount {
    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void calculateInterest() {
        double interest = balance * 0.05;
        deposit(interest);
    }
}

public class Bank {

    public static void main(String[] args) {
        // Creating an object of the SavingsAccount class
        SavingsAccount sa = new SavingsAccount();
        sa.deposit(1000);
        sa.withdraw(4000);
        sa.calculateInterest();
        System.out.println("Hello World Bank");
    }
}