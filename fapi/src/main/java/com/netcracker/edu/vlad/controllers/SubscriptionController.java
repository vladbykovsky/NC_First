package com.netcracker.edu.vlad.controllers;

import com.netcracker.edu.vlad.models.Subscription;
import com.netcracker.edu.vlad.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Subscription> getSubscriptionByUserId(@PathVariable Integer id) throws InterruptedException {
        return subscriptionService.getSubscriptionsByUserId(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Subscription> saveSubscription(@RequestBody Subscription subscription) {
        if (subscription != null) {
            return ResponseEntity.ok(subscriptionService.saveSubscription(subscription));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSubscription(@PathVariable int id) {
        subscriptionService.deleteSubscription(id);
    }
}
