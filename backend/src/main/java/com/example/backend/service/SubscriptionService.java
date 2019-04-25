package com.example.backend.service;

import com.example.backend.entity.Subscription;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface SubscriptionService {

    Optional<Subscription> findById(int id);
    Optional<Subscription> findByUserId(int id);
    Subscription saveSubscription(Subscription subscription);
    void delete(int id);

}
