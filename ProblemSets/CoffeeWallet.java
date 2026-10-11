package ProblemSets;


class CoffeeWal {
    String name;
    double balance;

    // Constructor
    CoffeeWal(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    // Add money
    void addFunds(double amount) {
        balance = balance + amount;
        System.out.println("Added: Rs. " + amount);
        System.out.println("Current Balance: Rs. " + balance);
    }

    // Make purchase
    void purchase(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Purchase successful!");
            System.out.println("Remaining Balance: Rs. " + balance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    // Display account details
    void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Current Balance: Rs. " + balance);
    }
}

public class CoffeeWallet {
    public static void main(String[] args) {
        CoffeeWal wallet = new CoffeeWal("Tanvi", 500);

        wallet.display();

        wallet.addFunds(200);

        wallet.purchase(150);

        wallet.purchase(800);

        wallet.display();
    }
}
