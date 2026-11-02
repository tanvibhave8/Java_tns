
package com.microwarehouse.entity;

import java.time.LocalDateTime;

public class Order {

    private int orderId;
    private String customerPhone;
    private String orderStatus;
    private LocalDateTime createdAt;

    // Default Constructor
    public Order() {
    }

    // Parameterized Constructor
    public Order(int orderId, String customerPhone,
                 String orderStatus, LocalDateTime createdAt) {

        this.orderId = orderId;
        this.customerPhone = customerPhone;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }

    // Getters and Setters

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerPhone='" + customerPhone + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
