
package com.microwarehouse.entity;

public class Product {

    private int skuId;
    private String name;
    private String category;
    private double unitPrice;
    private int stockQty;

    // Default Constructor
    public Product() {
    }

    // Parameterized Constructor
    public Product(int skuId, String name, String category,
                   double unitPrice, int stockQty) {

        this.skuId = skuId;
        this.name = name;
        this.category = category;
        this.unitPrice = unitPrice;
        this.stockQty = stockQty;
    }

    // Getters and Setters

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    // toString Method

    @Override
    public String toString() {
        return "Product{" +
                "skuId=" + skuId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", unitPrice=" + unitPrice +
                ", stockQty=" + stockQty +
                '}';
    }
}
