package com.netcracker.edu.vlad.controllers;

import com.netcracker.edu.vlad.models.Subscription;
import com.netcracker.edu.vlad.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable String id) throws InterruptedException {
        Long subscriptionId = Long.valueOf(id);
        return ResponseEntity.ok(subscriptionService.getSubscriptionById(subscriptionId));
    }

    @RequestMapping(value = "/userId/{id}")
    public ResponseEntity<Subscription> getSubscriptionByUserId(@PathVariable String id) throws InterruptedException {
        Integer subscriptionId = Integer.valueOf(id);
        return ResponseEntity.ok(subscriptionService.getSubscriptionByUserId(subscriptionId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Subscription> saveSubscription(@RequestBody Subscription subscription /*todo server validation*/) {
        if (subscription != null) {
            return ResponseEntity.ok(subscriptionService.saveSubscription(subscription));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSubscription(@PathVariable String id) {
        subscriptionService.deleteSubscription(Integer.valueOf(id));
    }
}
