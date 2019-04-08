package com.example.backend.service;

import com.example.backend.entity.Product;
import com.example.backend.entity.Subscription;

import java.util.List;

public interface SubscriptionService {

    Subscription findById(int id);
    Subscription findByStatus(String status);
    Subscription save(Subscription subscription);
    void delete(int id);

}
