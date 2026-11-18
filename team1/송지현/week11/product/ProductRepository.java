package com.example.demo.product;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductRepository {

    private Map<Integer, Product> db = new HashMap<>();
    private int id = 1;

    public Product getProduct(int id){
        return db.get(id);
    }
    public void saveProduct(Product product) {
        db.put(id++, product);
    }
}
