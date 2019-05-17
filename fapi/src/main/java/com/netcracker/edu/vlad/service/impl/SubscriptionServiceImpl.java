package com.netcracker.edu.vlad.service.impl;

import com.netcracker.edu.vlad.models.Subscription;
import com.netcracker.edu.vlad.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public Subscription getSubscriptionById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/subscription/" + id, Subscription.class);
    }

    @Override
    public List<Subscription> getSubscriptionsByUserId(int id) {
        RestTemplate restTemplate = new RestTemplate();
        Subscription[] subscriptionsResponse =
                restTemplate.getForObject(backendServerUrl + "/api/subscription/userId/" + id, Subscription[].class);
        return subscriptionsResponse == null ? Collections.emptyList() : Arrays.asList(subscriptionsResponse);
    }

    @Override
    public Subscription saveSubscription(Subscription subscription) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/subscription", subscription, Subscription.class).getBody();
    }

    @Override
    public void deleteSubscription(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/subscription/" + id);
    }
}
