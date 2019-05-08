package com.netcracker.edu.vlad.models;

import java.math.BigDecimal;

public class BillingAccount {
    private int billingId;
    private BigDecimal balance;
    private String cardType;
    private int userId;

    public BillingAccount(){

    }

    public BillingAccount(int billingId, BigDecimal balance, String cardType, int userId) {
        this.billingId = billingId;
        this.balance = balance;
        this.cardType = cardType;
        this.userId = userId;
    }

    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "BillingAccount{" +
                "billingId=" + billingId +
                ", balance=" + balance +
                ", cardType='" + cardType +
                ", userId=" + userId + '\'' +
                '}';
    }


}
