
package com.microwarehouse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microwarehouse.entity.Product;
import com.microwarehouse.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 1. Add New Product
    public int addProduct(Product product) {

        if (product.getName() == null ||
                product.getName().isBlank()) {
            throw new IllegalArgumentException(
                    "Product name cannot be empty");
        }

        if (product.getUnitPrice() < 0 ||
                product.getStockQty() < 0) {
            throw new IllegalArgumentException(
                    "Price and stock cannot be negative");
        }

        return productRepository.addProduct(product);
    }

    // 2. View All Products
    public List<Product> getAllProducts() {

        return productRepository.getAllProducts();
    }

    // 3. Find Product By ID
    public Product getProductById(int skuId) {

        return productRepository.getProductById(skuId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Product not found with SKU ID: " + skuId));
    }

    // 4. Replenish Stock
    public void replenishStock(int skuId, int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Replenishment quantity must be positive");
        }

        int rowsUpdated =
                productRepository.replenishStock(skuId, quantity);

        if (rowsUpdated == 0) {
            throw new IllegalArgumentException(
                    "Product not found with SKU ID: " + skuId);
        }
    }
}
