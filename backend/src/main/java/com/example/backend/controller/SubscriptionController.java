package com.example.backend.controller;

import com.example.backend.entity.Subscription;
import com.example.backend.service.ProductService;
import com.example.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping(value = "/{status}", method = RequestMethod.GET)
    public ResponseEntity<Subscription> getSubscriptionByStatus(@PathVariable(name = "status") String status) {
        Subscription subscription = subscriptionService.findByStatus(status);
        return ResponseEntity.ok(subscription);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Subscription> getProductById(@PathVariable(name = "id") Integer id){
        Optional<Subscription> subscription = subscriptionService.findById(id);
        if (subscription.isPresent()){
            return ResponseEntity.ok(subscription.get());
        }else {
            return  ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Subscription saveSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.saveSubscription(subscription);
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
    public void deleteSubscription(@PathVariable(name = "id") Integer id) {
        subscriptionService.delete(id); }

}
