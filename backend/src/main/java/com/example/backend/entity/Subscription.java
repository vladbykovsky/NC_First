package com.example.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subscriptions", schema = "nc_test", catalog = "")
public class Subscription {
    private int subscribeId;
    private String status;
    private int userId;
    private int productId;
    private int billingId;


    @Id
    @Column(name = "subscribe_id")
    public int getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(int subscribeId) {
        this.subscribeId = subscribeId;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "billing_id")
    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return subscribeId == that.subscribeId &&
                userId == that.userId &&
                productId == that.productId &&
                billingId == that.billingId &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscribeId, status, userId, productId, billingId);
    }
}
