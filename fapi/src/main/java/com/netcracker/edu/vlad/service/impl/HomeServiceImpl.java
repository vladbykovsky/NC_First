package com.netcracker.edu.vlad.service.impl;

import com.netcracker.edu.vlad.models.Product;
import com.netcracker.edu.vlad.service.HomeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HomeServiceImpl implements HomeService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public Page<Product> findAll(int page, int size) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl+"/api?page=" + page
                + "&size="+size, RestPageImpl.class);
    }

}
