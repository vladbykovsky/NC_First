package com.netcracker.edu.vlad.service;

import com.netcracker.edu.vlad.models.Subscription;

public interface SubscriptionService {
    Subscription getSubscriptionById(Long id);
    Subscription getSubscriptionByUserId(int id);
    Subscription saveSubscription(Subscription subscription);
    void deleteSubscription(int id);
}
