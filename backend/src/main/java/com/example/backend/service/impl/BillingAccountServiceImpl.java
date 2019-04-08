package com.example.backend.service.impl;

import com.example.backend.entity.BillingAccount;
import com.example.backend.repository.BillingAccountRepository;
import com.example.backend.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BillingAccountServiceImpl implements BillingAccountService {

    private BillingAccountRepository repository;

    @Autowired
    public BillingAccountServiceImpl(BillingAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public BillingAccount saveBillingAccount(BillingAccount account) {
        return repository.save(account);
    }

    @Override
    public Optional<BillingAccount> getBillingAccountById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<BillingAccount> getAllBillingAccounts() {
        return repository.findAll();
    }

    @Override
    public void deleteBillingAccount(Integer id) {
        repository.deleteById(id);
    }
}