package com.example.backend.service;

import com.example.backend.entity.BillingAccount;
import java.util.Optional;

public interface BillingAccountService {

    BillingAccount saveBillingAccount(BillingAccount account);
    Optional<BillingAccount> getBillingAccountById(Integer id);
    Iterable<BillingAccount> getAllBillingAccounts();
    void deleteBillingAccount(Integer id);

}
