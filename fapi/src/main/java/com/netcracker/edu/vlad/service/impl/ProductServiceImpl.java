package com.netcracker.edu.vlad.service.impl;

import com.netcracker.edu.vlad.models.Product;
import com.netcracker.edu.vlad.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public Page<Product> findAll(int page, int size) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl+"/api/admin/products?page=" + page
                        + "&size="+size, RestPageImpl.class);

    }

    @Override
    public List<Product> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Product[] productsResponse = restTemplate.getForObject(backendServerUrl + "/api/admin/products", Product[].class);
        return  productsResponse == null ? Collections.emptyList() : Arrays.asList(productsResponse);
    }

    @Override
    public Product findById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/product/" + id, Product.class);

    }

    @Override
    public Product findByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/admin/products/name/" + name, Product.class);
    }

    @Override
    public Product saveProduct(Product product) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/admin/products", product, Product.class).getBody();
    }

    @Override
    public void deleteProduct(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/admin/products/" + id);
    }
}
