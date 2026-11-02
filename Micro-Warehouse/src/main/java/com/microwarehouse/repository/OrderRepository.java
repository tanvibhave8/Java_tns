
package com.microwarehouse.repository;

import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.microwarehouse.entity.OrderItem;

@Repository
public class OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 1. Create New Order
    public int createOrder(String customerPhone) {

        String sql = "INSERT INTO orders " +
                "(customer_phone, order_status) " +
                "VALUES (?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {

            var ps = connection.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, customerPhone);
            ps.setString(2, "PENDING");

            return ps;

        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    // 2. Insert Multiple Order Items Using BatchUpdate
    public void addOrderItems(List<OrderItem> items) {

        String sql = "INSERT INTO order_items " +
                "(order_id, sku_id, quantity, subtotal) " +
                "VALUES (?, ?, ?, ?)";

        List<Object[]> batchArgs = items.stream()
                .map(item -> new Object[]{
                        item.getOrderId(),
                        item.getSkuId(),
                        item.getQuantity(),
                        item.getSubtotal()
                })
                .toList();

        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    // 3. Deduct Stock
    public int deductStock(int skuId, int quantity) {

        String sql = "UPDATE products " +
                "SET stock_qty = stock_qty - ? " +
                "WHERE sku_id = ? AND stock_qty >= ?";

        return jdbcTemplate.update(
                sql, quantity, skuId, quantity);
    }

    // 4. Update Order Status
    public int updateOrderStatus(int orderId, String status) {

        String sql = "UPDATE orders " +
                "SET order_status = ? WHERE order_id = ?";

        return jdbcTemplate.update(sql, status, orderId);
    }
}
