package com.netcracker.edu.vlad.service;

import com.netcracker.edu.vlad.models.BillingAccount;

import java.util.List;
import java.util.Optional;

public interface BillingAccountService {
    List<BillingAccount> getAll();
    BillingAccount getBillingAccountById(Long id);
    BillingAccount getBillingAccountByUserId(Long id);
    BillingAccount saveBillingAccount(BillingAccount account);
    void deleteBillingAccount(Long id);
}
