package com.onesight.searchdemo.controllers;

import com.onesight.searchdemo.models.Product;
import com.onesight.searchdemo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping
    @RequestMapping("{productName}")
    @CrossOrigin(origins = {"*"})
    public List<Product> list(@PathVariable String productName) {
        return productRepository.findProductByProductName(productName.toLowerCase());
    }
}
