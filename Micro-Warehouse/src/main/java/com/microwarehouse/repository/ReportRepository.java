
package com.microwarehouse.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.microwarehouse.entity.Product;
import com.microwarehouse.repository.mapper.ProductRowMapper;

@Repository
public class ReportRepository {

    private final JdbcTemplate jdbcTemplate;

    public ReportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 1. Get Low Stock Products
    public List<Product> getLowStockProducts(int threshold) {

        String sql = "SELECT * FROM products " +
                "WHERE stock_qty < ? ORDER BY stock_qty ASC";

        return jdbcTemplate.query(
                sql,
                new ProductRowMapper(),
                threshold
        );
    }

    // 2. Calculate Total Fulfillment Revenue
    public BigDecimal getTotalRevenue() {

        String sql = "SELECT COALESCE(SUM(oi.subtotal), 0) " +
                "FROM orders o " +
                "JOIN order_items oi ON o.order_id = oi.order_id " +
                "WHERE o.order_status IN ('CONFIRMED', 'DISPATCHED')";

        return jdbcTemplate.queryForObject(
                sql,
                BigDecimal.class
        );
    }

    // 3. Get Top Selling Products
    public List<Map<String, Object>> getTopSellingProducts() {

        String sql = "SELECT p.sku_id, p.name, " +
                "SUM(oi.quantity) AS total_sold, " +
                "SUM(oi.subtotal) AS total_revenue " +
                "FROM products p " +
                "JOIN order_items oi ON p.sku_id = oi.sku_id " +
                "JOIN orders o ON oi.order_id = o.order_id " +
                "WHERE o.order_status IN ('CONFIRMED', 'DISPATCHED') " +
                "GROUP BY p.sku_id, p.name " +
                "ORDER BY total_sold DESC";

        return jdbcTemplate.queryForList(sql);
    }
}
