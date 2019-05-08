package com.netcracker.edu.vlad.controllers;

import com.netcracker.edu.vlad.models.BillingAccount;
import com.netcracker.edu.vlad.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billing-account")
public class BillingAccountController {
    @Autowired
    private BillingAccountService billingAccountService;

    @RequestMapping
    public ResponseEntity<List<BillingAccount>> getAllBillingAccounts() {
        return ResponseEntity.ok(billingAccountService.getAll());
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<BillingAccount> getAllBillingAccountsById(@PathVariable String id) throws InterruptedException {
        Long billingAccountId = Long.valueOf(id);
        return ResponseEntity.ok(billingAccountService.getBillingAccountById(billingAccountId));
    }

    @RequestMapping(value = "/userId/{id}")
    public ResponseEntity<BillingAccount> getBillingAccountByUserId(@PathVariable String id) throws InterruptedException {
        Long billingAccountId = Long.valueOf(id);
        return ResponseEntity.ok(billingAccountService.getBillingAccountByUserId(billingAccountId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<BillingAccount> saveBillingAccount(@RequestBody BillingAccount billingAccount /*todo server validation*/) {
        if (billingAccount != null) {
            return ResponseEntity.ok(billingAccountService.saveBillingAccount(billingAccount));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBillingAccount(@PathVariable String id) {
        billingAccountService.deleteBillingAccount(Long.valueOf(id));
    }


}
