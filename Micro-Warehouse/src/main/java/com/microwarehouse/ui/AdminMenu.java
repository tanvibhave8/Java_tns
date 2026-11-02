
package com.microwarehouse.ui;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.microwarehouse.entity.Product;
import com.microwarehouse.service.ProductService;
import com.microwarehouse.service.ReportService;

@Component
public class AdminMenu {

    private final ProductService productService;
    private final ReportService reportService;

    public AdminMenu(ProductService productService,
                     ReportService reportService) {

        this.productService = productService;
        this.reportService = reportService;
    }

    public void showMenu(Scanner sc) {

        int choice;

        do {
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. Add New Product");
            System.out.println("2. View All Products");
            System.out.println("3. Replenish Stock");
            System.out.println("4. View Low Stock Alerts");
            System.out.println("5. View Total Revenue");
            System.out.println("6. View Top Selling Products");
            System.out.println("7. Back to Main Menu");

            System.out.print("Enter your choice: ");

            choice = readInt(sc);

            try {

                switch (choice) {

                    case 1:
                        addProduct(sc);
                        break;

                    case 2:
                        viewProducts();
                        break;

                    case 3:
                        replenishStock(sc);
                        break;

                    case 4:
                        showLowStockAlerts(sc);
                        break;

                    case 5:
                        showRevenue();
                        break;

                    case 6:
                        showTopSellingProducts();
                        break;

                    case 7:
                        System.out.println("Returning to Main Menu...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 7);
    }

    // 1. Add New Product
    private void addProduct(Scanner sc) {

        System.out.println("\n--- ADD NEW PRODUCT ---");

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter Category: ");
        String category = sc.nextLine().trim();

        System.out.print("Enter Unit Price: ");
        double price = readDouble(sc);

        System.out.print("Enter Initial Stock: ");
        int stock = readInt(sc);

        Product product = new Product(
                0, name, category, price, stock
        );

        int skuId = productService.addProduct(product);

        System.out.println("Product added successfully!");
        System.out.println("Generated SKU ID: " + skuId);
    }

    // 2. View All Products
    private void viewProducts() {

        System.out.println("\n--- PRODUCT INVENTORY ---");

        List<Product> products = productService.getAllProducts();

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product product : products) {
            System.out.println(product);
        }
    }

    // 3. Replenish Stock
    private void replenishStock(Scanner sc) {

        System.out.println("\n--- REPLENISH STOCK ---");

        System.out.print("Enter SKU ID: ");
        int skuId = readInt(sc);

        System.out.print("Enter Quantity to Add: ");
        int quantity = readInt(sc);

        productService.replenishStock(skuId, quantity);

        System.out.println("Stock replenished successfully!");
    }

    // 4. Low Stock Alerts
    private void showLowStockAlerts(Scanner sc) {

        System.out.println("\n--- LOW STOCK ALERTS ---");

        System.out.print("Enter Minimum Stock Threshold: ");
        int threshold = readInt(sc);

        List<Product> products =
                reportService.getLowStockAlerts(threshold);

        if (products.isEmpty()) {
            System.out.println("No low stock products found.");
            return;
        }

        for (Product product : products) {
            System.out.println(
                    product.getName() +
                    " | SKU: " + product.getSkuId() +
                    " | Available Stock: " + product.getStockQty()
            );
        }
    }

    // 5. Total Revenue
    private void showRevenue() {

        System.out.println("\n--- TOTAL FULFILLMENT REVENUE ---");

        BigDecimal revenue = reportService.getTotalRevenue();

        System.out.println("Total Revenue: Rs. " + revenue);
    }

    // 6. Top Selling Products
    private void showTopSellingProducts() {

        System.out.println("\n--- TOP SELLING PRODUCTS ---");

        List<Map<String, Object>> products =
                reportService.getTopSellingProducts();

        if (products.isEmpty()) {
            System.out.println("No sales records available yet.");
            return;
        }

        for (Map<String, Object> product : products) {

            System.out.println(
                    "Product: " + product.get("name") +
                    " | SKU: " + product.get("sku_id") +
                    " | Units Sold: " + product.get("total_sold") +
                    " | Revenue: Rs. " + product.get("total_revenue")
            );
        }
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

    // Read Decimal Input
    private double readDouble(Scanner sc) {

        while (!sc.hasNextDouble()) {
            System.out.print("Please enter a valid amount: ");
            sc.nextLine();
        }

        double value = sc.nextDouble();
        sc.nextLine();

        return value;
    }
}
