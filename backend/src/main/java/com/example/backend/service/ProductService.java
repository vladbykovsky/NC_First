package com.example.backend.service;

import com.example.backend.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();
    Optional<Product> findById(int id);
    Product findByName(String name);
    Product saveProduct(Product product);
    void deleteProduct(int id);

}
