package com.onesight.searchdemo.controllers;

import com.onesight.searchdemo.models.Product;
import com.onesight.searchdemo.repositories.ProductRepository;
import com.onesight.searchdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @GetMapping
    @RequestMapping("{productName}")
    @CrossOrigin(origins = {"*"})
    public List<Product> list(@PathVariable String productName) {
        return productService.listProducts(productName);
    }
}
