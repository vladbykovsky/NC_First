package com.netcracker.edu.vlad.service;

import com.netcracker.edu.vlad.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Page<Product> findAll(int page, int size);
    Product findById(int id);
    Product findByName(String name);
    Product saveProduct(Product product);
    void deleteProduct(int id);
}
