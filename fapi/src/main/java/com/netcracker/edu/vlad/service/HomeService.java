package com.netcracker.edu.vlad.service;

import com.netcracker.edu.vlad.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HomeService {
//    Page<Product> findAll(int page, String sort, String order);
    Page<Product> findAll(int page, int size, String sort, String order);
    Product findAllByNameStartWith(String str);
}
