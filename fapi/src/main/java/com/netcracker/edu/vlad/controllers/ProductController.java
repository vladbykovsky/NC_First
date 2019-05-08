package com.netcracker.edu.vlad.controllers;

import com.netcracker.edu.vlad.models.Product;
import com.netcracker.edu.vlad.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.findById(id);
    }
}
