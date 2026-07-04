package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component                  // IOC
public class ProductService {
    private ProductRepository productRepository;

    @Autowired              // 생성자 주입 방식
    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String getProduct() {
        return productRepository.getProduct();
    }
}
