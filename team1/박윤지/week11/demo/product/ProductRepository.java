package com.example.demo.product;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {
    Map<Integer, Product> db = new HashMap<>();
    private int id = 1;

    public Product getProduct(int id) {
        return db.get(id);
    }

    public void saveProduct(Product product) {
        db.put(id++, product);
    }
}
