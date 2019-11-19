package com.example.backend.service;

import com.example.backend.entity.BillingAccount;
import com.example.backend.entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.Optional;

@Configuration
@EnableScheduling
public class ChargingService {
    @Autowired
    private BillingAccountService billingAccountService;
    @Autowired
    private SubscriptionService subscriptionService;

    @Scheduled(fixedDelay = 20000)
    public void charging(){
        ArrayList<Subscription> subscriptions = (ArrayList<Subscription>)subscriptionService.findAll();

        for (Subscription subscription: subscriptions){

            Optional<BillingAccount> billingAccount =
                    billingAccountService.getBillingAccountById(subscription.getBillingId());

            Optional<BillingAccount> ownerBA = billingAccountService.getBillingAccountByUserId(
                    subscription.getProduct().getUsersByOwnerId().getUserId());

            double productPrice;

            if(subscription.getProduct().getPrice() < 0) {
                productPrice = 0;
            }else {
                productPrice = subscription.getProduct().getPrice();
            }

            if(billingAccount.get().getBalance() < productPrice){
                subscription.setStatus("block");
                subscriptionService.saveSubscription(subscription);
            }else {
                subscription.setStatus("active");
                subscriptionService.saveSubscription(subscription);
                billingAccount.get().setBalance(billingAccount.get().getBalance() - productPrice);
                ownerBA.get().setBalance(ownerBA.get().getBalance() + productPrice);
                billingAccountService.saveBillingAccount(billingAccount.get());
                billingAccountService.saveBillingAccount(ownerBA.get());
            }
        }
    }
}
