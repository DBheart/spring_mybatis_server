package com.example.demo.sample;

import com.example.demo.sample.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
//@Runwith(SpringRunner.class)
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void getProductById() {
        Product product = productService.getProductById(1L);
        log.info("product : {}", product);
    }

    @Test
    public void getAllProducts() {
        List<Product> products = productService.getAllProducts();
        log.info("products : {}", products);
    }

    @Transactional
    @Test
    public void addProduct() {
        productService.addProduct(new Product("쿤달 샴푸", 7900));
        productService.addProduct(new Product("마스크팩", 1000));
        productService.addProduct(new Product("티셔츠", 5900));
    }
}