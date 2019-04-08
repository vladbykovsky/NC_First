package com.example.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "billing_acсounts", schema = "nc_test", catalog = "")
public class BillingAccount {
    private int billingId;
    private BigDecimal balance;
    private String cardType;
    private Collection<Subscription> subscriptionsByBillingId;

    @Id
    @Column(name = "billing_id")
    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    @Basic
    @Column(name = "balance")
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "card_type")
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillingAccount that = (BillingAccount) o;
        return billingId == that.billingId &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(cardType, that.cardType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingId, balance, cardType);
    }

    @OneToMany(mappedBy = "billingAcсountsByBillingId")
    public Collection<Subscription> getSubscriptionsByBillingId() {
        return subscriptionsByBillingId;
    }

    public void setSubscriptionsByBillingId(Collection<Subscription> subscriptionsByBillingId) {
        this.subscriptionsByBillingId = subscriptionsByBillingId;
    }
}
