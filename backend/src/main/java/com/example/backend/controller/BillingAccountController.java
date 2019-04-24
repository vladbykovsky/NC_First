package com.example.backend.controller;

import com.example.backend.entity.BillingAccount;
import com.example.backend.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/billing-account")
public class BillingAccountController {

    private BillingAccountService billingAccountService;

    @Autowired
    public BillingAccountController(BillingAccountService billingAccountService) {
        this.billingAccountService = billingAccountService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<BillingAccount> getBillingAccountById(@PathVariable(name = "id") Integer id) {
        Optional<BillingAccount> billingAccount = billingAccountService.getBillingAccountById(id);
        if (billingAccount.isPresent()) {
            return ResponseEntity.ok(billingAccount.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/userId/{id}", method = RequestMethod.GET)
    public ResponseEntity<BillingAccount> getBillingAccountByUserId(@PathVariable(name = "id") Integer id) {
        Optional<BillingAccount> billingAccount = billingAccountService.getBillingAccountByUserId(id);
        if (billingAccount.isPresent()) {
            return ResponseEntity.ok(billingAccount.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<BillingAccount> getAllBillingAccounts() {
        return billingAccountService.getAllBillingAccounts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public BillingAccount saveBillingAccount(@RequestBody BillingAccount account) {
        return billingAccountService.saveBillingAccount(account);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBillingAccount(@PathVariable(name = "id") Integer id) {
        billingAccountService.deleteBillingAccount(id);
    }

}
