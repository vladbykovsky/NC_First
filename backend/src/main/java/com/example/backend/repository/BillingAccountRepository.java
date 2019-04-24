package com.example.backend.repository;

import com.example.backend.entity.BillingAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillingAccountRepository extends CrudRepository<BillingAccount, Integer> {
    Optional<BillingAccount> findByUserId(Integer id);
}

