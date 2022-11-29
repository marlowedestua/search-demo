package com.onesight.searchdemo.service;

import com.onesight.searchdemo.models.Product;
import com.onesight.searchdemo.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> listProducts (String productName) {
        return productRepository.findProductByProductName(productName.toLowerCase());
    }
}
