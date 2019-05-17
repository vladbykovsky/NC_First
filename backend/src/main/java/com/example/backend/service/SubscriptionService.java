package com.example.backend.service;

import com.example.backend.entity.Subscription;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface SubscriptionService {

    Optional<Subscription> findById(int id);
    Optional<Subscription> findByUserId(int id);
    List<Subscription> getSubscriptionsByUserId(int id);
    Subscription saveSubscription(Subscription subscription);
    void delete(int id);

}
