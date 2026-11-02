
package com.microwarehouse.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.microwarehouse.entity.Product;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum)
            throws SQLException {

        Product product = new Product();

        product.setSkuId(rs.getInt("sku_id"));
        product.setName(rs.getString("name"));
        product.setCategory(rs.getString("category"));
        product.setUnitPrice(rs.getDouble("unit_price"));
        product.setStockQty(rs.getInt("stock_qty"));

        return product;
    }
}
