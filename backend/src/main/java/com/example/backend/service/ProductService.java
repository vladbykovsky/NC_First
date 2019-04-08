package com.example.backend.service;

import com.example.backend.entity.Product;
import com.example.backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();
    Product findByName(String name);
    Product findByCategory(String category);
    Product findByCompany(String company);
    Product save(Product product);
    void delete(int id);

}
