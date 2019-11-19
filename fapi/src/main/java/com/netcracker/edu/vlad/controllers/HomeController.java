package com.netcracker.edu.vlad.controllers;

import com.netcracker.edu.vlad.models.Product;
import com.netcracker.edu.vlad.service.HomeService;
import com.netcracker.edu.vlad.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam int page,
                                                        @RequestParam int size,
                                                        @RequestParam String sort,
                                                        @RequestParam String order){
        Page<Product> products = homeService.findAll(page, size, sort, order);
        if (products.getContent() != null) {
            return ResponseEntity.ok(products);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam int page,
//                                                        @RequestParam String sort,
//                                                        @RequestParam String order){
//        Page<Product> products = homeService.findAll(page, sort, order);
//        if (products.getContent() != null) {
//            return ResponseEntity.ok(products);
//        }else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
    public Product getAllByName(@PathVariable(name = "name") String name){
        return homeService.findAllByNameStartWith(name);
    }
}
