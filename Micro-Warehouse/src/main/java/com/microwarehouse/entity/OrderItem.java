
package com.microwarehouse.entity;

public class OrderItem {

    private int itemId;
    private int orderId;
    private int skuId;
    private int quantity;
    private double subtotal;

    // Default Constructor
    public OrderItem() {
    }

    // Parameterized Constructor
    public OrderItem(int itemId, int orderId, int skuId,
                     int quantity, double subtotal) {

        this.itemId = itemId;
        this.orderId = orderId;
        this.skuId = skuId;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    // Getters and Setters

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemId=" + itemId +
                ", orderId=" + orderId +
                ", skuId=" + skuId +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                '}';
    }
}
