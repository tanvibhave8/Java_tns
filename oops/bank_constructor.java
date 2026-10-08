package oops;

class BankAccount {
    int balance;
    int withdrawal;

    BankAccount(int balance, int withdrawal) {
        this.balance = balance;
        this.withdrawal = withdrawal;
    }

    void current_balance() {
        System.out.println("Current Balance : " + balance);
    }

    void withdraw() {
        if (withdrawal > balance) {
            System.out.println("Sorry! Your balance is less, you cannot withdraw money.");
            System.out.println("Current Balance = " + balance);
        } else {
            balance = balance - withdrawal;
            System.out.println(withdrawal + " withdrawn.");
            System.out.println("Current Balance : " + balance);
        }
    }
}

public class bank_constructor {
    public static void main(String[] args) {

        BankAccount b1 = new BankAccount(100, 10);

        b1.current_balance();
        b1.withdraw();
    }
}