
package com.microwarehouse.ui;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleApplication implements CommandLineRunner {

    private final AdminMenu adminMenu;
    private final CustomerMenu customerMenu;

    public ConsoleApplication(AdminMenu adminMenu,
                              CustomerMenu customerMenu) {

        this.adminMenu = adminMenu;
        this.customerMenu = customerMenu;
    }

    @Override
    public void run(String... args) {

        try (Scanner sc = new Scanner(System.in)) {

            int choice;

            do {

                System.out.println("\n================================");
                System.out.println("   MICRO WAREHOUSE HUB");
                System.out.println(" Inventory & Order Fulfillment");
                System.out.println("================================");

                System.out.println("1. Admin Menu");
                System.out.println("2. Customer Menu");
                System.out.println("3. Exit");

                System.out.print("\nEnter your choice: ");

                while (!sc.hasNextInt()) {
                    System.out.print("Enter a valid number: ");
                    sc.nextLine();
                }

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        adminMenu.showMenu(sc);
                        break;

                    case 2:
                        customerMenu.showMenu(sc);
                        break;

                    case 3:
                        System.out.println(
                                "Thank you for using Micro Warehouse Hub!");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } while (choice != 3);
        }
    }
}
