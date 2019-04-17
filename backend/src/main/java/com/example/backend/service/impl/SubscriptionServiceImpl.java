package com.example.backend.service.impl;

import com.example.backend.entity.Subscription;
import com.example.backend.repository.SubscriptionRepository;
import com.example.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired SubscriptionServiceImpl(SubscriptionRepository repository){
        this.subscriptionRepository = repository;
    }

    @Override
    public Optional<Subscription> findById(int id) {
        return subscriptionRepository.findById(id);
    }

    @Override
    public Subscription findByStatus(String status) {
        return subscriptionRepository.findByStatus(status);
    }

    @Override
    public Subscription saveSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void delete(int id) {
        subscriptionRepository.deleteById(id);
    }
}
