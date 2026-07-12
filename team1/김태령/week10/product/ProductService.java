package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {


    private ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public String getProduct(int id){
        return productRepository.getProduct(id);
    }

    public void saveProduct(String productName) {
        productRepository.saveProduct(productName);
    }
}
