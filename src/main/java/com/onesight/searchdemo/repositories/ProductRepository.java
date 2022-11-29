package com.onesight.searchdemo.repositories;

import com.onesight.searchdemo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query(value = "SELECT p FROM Product p WHERE LOWER(p.productName) LIKE %:productName% ORDER BY p.productName")
    List<Product> findProductByProductName(String productName);
}
