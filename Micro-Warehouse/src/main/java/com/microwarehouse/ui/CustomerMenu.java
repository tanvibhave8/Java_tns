
package com.microwarehouse.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.microwarehouse.entity.OrderItem;
import com.microwarehouse.entity.Product;
import com.microwarehouse.service.OrderService;
import com.microwarehouse.service.ProductService;

@Component
public class CustomerMenu {

    private final ProductService productService;
    private final OrderService orderService;

    public CustomerMenu(ProductService productService,
                        OrderService orderService) {

        this.productService = productService;
        this.orderService = orderService;
    }

    public void showMenu(Scanner sc) {

        int choice;

        do {
            System.out.println("\n===== CUSTOMER MENU =====");
            System.out.println("1. View Available Products");
            System.out.println("2. Place New Order");
            System.out.println("3. Back to Main Menu");

            System.out.print("Enter your choice: ");

            choice = readInt(sc);

            try {

                switch (choice) {

                    case 1:
                        viewProducts();
                        break;

                    case 2:
                        placeOrder(sc);
                        break;

                    case 3:
                        System.out.println("Returning to Main Menu...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 3);
    }

    // 1. View Available Products
    private void viewProducts() {

        System.out.println("\n--- AVAILABLE PRODUCTS ---");

        List<Product> products = productService.getAllProducts();

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product product : products) {

            System.out.println(
                    "SKU: " + product.getSkuId() +
                    " | Name: " + product.getName() +
                    " | Category: " + product.getCategory() +
                    " | Price: Rs. " + product.getUnitPrice() +
                    " | Stock: " + product.getStockQty()
            );
        }
    }

    // 2. Place New Order
    private void placeOrder(Scanner sc) {

        System.out.println("\n--- PLACE NEW ORDER ---");

        System.out.print("Enter Customer Phone Number: ");
        String phone = sc.nextLine().trim();

        if (!phone.matches("\\+?[0-9]{10,15}")) {
            System.out.println("Please enter a valid phone number.");
            return;
        }

        viewProducts();

        System.out.print("\nHow many different products do you want? ");
        int count = readInt(sc);

        if (count <= 0 || count > 100) {
            System.out.println("Invalid number of products.");
            return;
        }

        List<OrderItem> items = new ArrayList<>();

        for (int i = 1; i <= count; i++) {

            System.out.println("\nProduct " + i);

            System.out.print("Enter SKU ID: ");
            int skuId = readInt(sc);

            System.out.print("Enter Quantity: ");
            int quantity = readInt(sc);

            items.add(new OrderItem(
                    0, 0, skuId, quantity, 0
            ));
        }

        int orderId = orderService.placeOrder(phone, items);

        System.out.println("\n===== ORDER RESULT =====");
        System.out.println("Order ID: " + orderId);

        // Check final order status
        if (items.stream().allMatch(item -> item.getOrderId() == orderId)) {
            // Order status is confirmed or rejected in the database.
            System.out.println("Order processing completed.");
            System.out.println("Check the database for final order status.");
        }

        System.out.println("========================");
    }

    // Read Integer Input
    private int readInt(Scanner sc) {

        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.nextLine();
        }

        int value = sc.nextInt();
        sc.nextLine();

        return value;
    }
}
