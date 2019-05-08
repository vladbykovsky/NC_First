package com.netcracker.edu.vlad.service.impl;

import com.netcracker.edu.vlad.models.BillingAccount;
import com.netcracker.edu.vlad.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BillingAccountServiceImpl implements BillingAccountService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<BillingAccount> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        BillingAccount[] billingAccountViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/billing-account/", BillingAccount[].class);
        return billingAccountViewModelResponse == null ? Collections.emptyList() : Arrays.asList(billingAccountViewModelResponse);
    }

    @Override
    public BillingAccount getBillingAccountById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/billing-account/" + id, BillingAccount.class);
    }

    @Override
    public BillingAccount getBillingAccountByUserId(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/billing-account/userId/" + id, BillingAccount.class);
    }

    @Override
    public BillingAccount saveBillingAccount(BillingAccount account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/billing-account", account, BillingAccount.class).getBody();
    }

    @Override
    public void deleteBillingAccount(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/billing-account/" + id);
    }
}
