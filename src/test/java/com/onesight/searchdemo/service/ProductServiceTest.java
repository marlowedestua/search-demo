package com.onesight.searchdemo.service;

import com.onesight.searchdemo.models.Product;
import com.onesight.searchdemo.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.UUID;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Slf4j
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
@Testcontainers
@ContextConfiguration(initializers = SharedDatabaseInstance.Initializer.class)
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Test
    @AfterEach()
    @Order(1)
    void clean() {
        productRepository.deleteAll();
    }

    @Test
    @Order(2)
    @Sql("/product-list.sql")
    void whenProductNameDoesNotExist_thenReturnZero () {
        List<Product> productList = productService.listProducts("xxxx");
        Assertions.assertEquals(productList.size(), 0);
    }

    @Test
    @Order(3)
    @Sql("/product-list.sql")
    void whenProductNameExists_thenReturnResult() {
        List<Product> productList = productService.listProducts("Licensed Steel Sausages");
        Assertions.assertTrue(productList.size() > 0);
        Assertions.assertEquals(UUID.fromString("4b3e9101-fa3c-4224-9dfd-6c3c473475df"), productList.get(0).getProductId());
        Assertions.assertEquals("http://omnis.info", productList.get(0).getProductLink());
    }
}
