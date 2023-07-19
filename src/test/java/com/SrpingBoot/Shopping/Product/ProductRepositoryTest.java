package com.SrpingBoot.Shopping.Product;

import com.SrpingBoot.Shopping.ShoppingApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = ShoppingApplication.class)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;


    @Test
    public void testFindAll() {
        // When
        List<Product> allProducts = productRepository.findAll();

        // Then

        for (Product product : allProducts) {
            System.out.println("Product ID: " + product.getId());
            System.out.println("Product Name: " + product.getName());
            System.out.println("Product Price: " + product.getPrice());
        }
    }
}

