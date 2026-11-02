
package com.microwarehouse.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.microwarehouse.entity.Product;
import com.microwarehouse.repository.mapper.ProductRowMapper;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 1. Add New Product
    public int addProduct(Product product) {

        String sql = "INSERT INTO products " +
                "(name, category, unit_price, stock_qty) " +
                "VALUES (?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement(
                    sql, java.sql.Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, product.getName());
            ps.setString(2, product.getCategory());
            ps.setDouble(3, product.getUnitPrice());
            ps.setInt(4, product.getStockQty());

            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    // 2. View All Products
    public List<Product> getAllProducts() {

        String sql = "SELECT * FROM products";

        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    // 3. Find Product By SKU ID
    public Optional<Product> getProductById(int skuId) {

        String sql = "SELECT * FROM products WHERE sku_id = ?";

        List<Product> products = jdbcTemplate.query(
                sql,
                new ProductRowMapper(),
                skuId
        );

        return products.stream().findFirst();
    }

    // 4. Update Stock Quantity
    public int updateStock(int skuId, int quantity) {

        String sql = "UPDATE products SET stock_qty = ? " +
                "WHERE sku_id = ?";

        return jdbcTemplate.update(sql, quantity, skuId);
    }

    // 5. Replenish Stock
    public int replenishStock(int skuId, int quantity) {

        String sql = "UPDATE products " +
                "SET stock_qty = stock_qty + ? " +
                "WHERE sku_id = ?";

        return jdbcTemplate.update(sql, quantity, skuId);
    }
}
