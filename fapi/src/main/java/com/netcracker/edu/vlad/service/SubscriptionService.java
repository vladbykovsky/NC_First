package com.netcracker.edu.vlad.service;

import com.netcracker.edu.vlad.models.Subscription;

import java.util.List;

public interface SubscriptionService {
    Subscription getSubscriptionById(Long id);
    List<Subscription> getSubscriptionsByUserId(int id);
    Subscription saveSubscription(Subscription subscription);
    void deleteSubscription(int id);
}
