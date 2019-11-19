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
    public Page<Product> findAll(int page, int size, String sort, String order) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api?page=" + page
                + "&size=" + size + "&sort=" + sort + "&order=" + order, RestPageImpl.class);
    }

//    @Override
//    public Page<Product> findAll(int page, String sort, String order) {
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForObject(backendServerUrl + "/api?page=" + page
//                +"&sort=" + sort + "&order=" + order, RestPageImpl.class);
//    }

    @Override
    public Product findAllByNameStartWith(String name) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl+"/api/search/"+name, Product.class);
    }

}
