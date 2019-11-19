package com.example.backend.controller;

import com.example.backend.entity.Product;
import com.example.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HomeController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "4") int size,
                                        @RequestParam String sort,
                                        @RequestParam String order) {
        Page<Product> productPage = null;
        if(!sort.equals("null") && !order.equals("null")){
            switch (order){
                case "low":{
                    productPage = productService.findAll(new PageRequest(page, size, Sort.by(sort).ascending()));
                    break;
                }
                case "high":{
                    productPage = productService.findAll(new PageRequest(page, size, Sort.by(sort).descending()));
                    break;
                }
            }
        }
        if(!sort.equals("null") && order.equals("null")){
            productPage = productService.findAll(new PageRequest(page, size, Sort.by(sort).ascending()));
        }
        if(sort.equals("null") && !order.equals("null")){
            productPage = productService.findAll(new PageRequest(page, size, Sort.by("category").ascending()));
        }
        if(sort.equals("null") && order.equals("null")){
            productPage = productService.findAll(new PageRequest(page, size, Sort.by("productId").descending()));
        }
        return productPage;
    }

    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
    public ResponseEntity<Product> getAllByNameStartWith(@PathVariable(name = "name") String name){
        Optional<Product> product = productService.findByNameStartingWith(name);
        if (product.isPresent()){
            return ResponseEntity.ok(product.get());
        }else {
            return  ResponseEntity.notFound().build();
        }
    }

}
