package com.netcracker.edu.vlad.models;

public class Subscription {
    private int subscribeId;
    private String status;
    private String dataStart;
    private String dataEnd;
    private int userId;
    private int productId;
    private int billingId;
    private Product product;



    Subscription(){}

    public Subscription(int subscribeId, String status, String dataStart, String dataEnd, int userId, int productId, int billingId, Product product) {
        this.subscribeId = subscribeId;
        this.status = status;
        this.dataStart = dataStart;
        this.dataEnd = dataEnd;
        this.userId = userId;
        this.productId = productId;
        this.billingId = billingId;
        this.product = product;
    }

    public int getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(int subscribeId) {
        this.subscribeId = subscribeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataStart() {
        return dataStart;
    }

    public void setDataStart(String dataStart) {
        this.dataStart = dataStart;
    }

    public String getDataEnd() {
        return dataEnd;
    }

    public void setDataEnd(String dataEnd) {
        this.dataEnd = dataEnd;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "subscribeId=" + subscribeId +
                ", status='" + status + '\'' +
                ", dataStart='" + dataStart + '\'' +
                ", dataEnd='" + dataEnd + '\'' +
                ", userId=" + userId +
                ", productId=" + productId +
                ", billingId=" + billingId +
                ", product=" + product +
                '}';
    }
}
