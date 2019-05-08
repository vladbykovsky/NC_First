package com.netcracker.edu.vlad.controllers;

import com.netcracker.edu.vlad.models.Product;
import com.netcracker.edu.vlad.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin/products")
public class AdminProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Product> getAllProducts(int page, int size){
        return productService.findAll(page, size);
    }

    @GetMapping("/name/{name}")
    public Product getProductByName(@PathVariable String name) {
        return productService.findByName(name);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.findById(id);
    }

}