
package com.microwarehouse.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microwarehouse.entity.OrderItem;
import com.microwarehouse.entity.Product;
import com.microwarehouse.repository.OrderRepository;
import com.microwarehouse.repository.ProductRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository,
                        ProductRepository productRepository) {

        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    // Create Multi-Item Order
    @Transactional
    public int placeOrder(String customerPhone,
                          List<OrderItem> items) {

        if (customerPhone == null || customerPhone.isBlank()) {
            throw new IllegalArgumentException(
                    "Customer phone cannot be empty");
        }

        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException(
                    "Order must contain at least one product");
        }

        // Step 1: Validate quantities and aggregate duplicate SKUs
        Map<Integer, Integer> requestedStock = new LinkedHashMap<>();

        for (OrderItem item : items) {

            if (item.getSkuId() <= 0 || item.getQuantity() <= 0) {
                throw new IllegalArgumentException(
                        "Invalid product ID or quantity");
            }

            requestedStock.merge(
                    item.getSkuId(),
                    item.getQuantity(),
                    Integer::sum
            );
        }

        // Step 2: Check availability of every product
        Map<Integer, Product> products = new LinkedHashMap<>();

        boolean available = true;

        for (Map.Entry<Integer, Integer> entry
                : requestedStock.entrySet()) {

            Product product = productRepository
                    .getProductById(entry.getKey())
                    .orElse(null);

            if (product == null ||
                    product.getStockQty() < entry.getValue()) {

                available = false;
                break;
            }

            products.put(entry.getKey(), product);
        }

        // Step 3: Create order
        int orderId = orderRepository.createOrder(customerPhone);

        // Step 4: Reject if any product is unavailable
        if (!available) {

            orderRepository.updateOrderStatus(
                    orderId, "REJECTED");

            return orderId;
        }

        // Step 5: Prepare order items and calculate subtotals
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItem item : items) {

            Product product = products.get(item.getSkuId());

            item.setOrderId(orderId);

            double subtotal =
                    product.getUnitPrice() * item.getQuantity();

            item.setSubtotal(subtotal);

            orderItems.add(item);
        }

        // Step 6: Deduct stock for all products
        for (Map.Entry<Integer, Integer> entry
                : requestedStock.entrySet()) {

            int rowsUpdated = orderRepository.deductStock(
                    entry.getKey(),
                    entry.getValue()
            );

            if (rowsUpdated != 1) {
                throw new IllegalStateException(
                        "Stock deduction failed. Order rolled back.");
            }
        }

        // Step 7: Insert all order items using batchUpdate
        orderRepository.addOrderItems(orderItems);

        // Step 8: Confirm order
        orderRepository.updateOrderStatus(
                orderId, "CONFIRMED");

        return orderId;
    }
}
