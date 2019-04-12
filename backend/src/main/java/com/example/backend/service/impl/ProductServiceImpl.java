package com.example.backend.service.impl;

import com.example.backend.entity.Product;
import com.example.backend.repository.ProductRepository;
import com.example.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository){ this.productRepository = repository; }

    @Override
    public List<Product> findAll() { return (List<Product>) productRepository.findAll(); }

    @Override
    public Optional<Product> findById(int id) { return  productRepository.findById(id); }

    @Override
    public Product findByName(String name) { return productRepository.findByName(name); }

    @Override
    public Product saveProduct(Product product) { return productRepository.save(product); }

    @Override
    public void deleteProduct(int id) { productRepository.deleteById(id); }
}
