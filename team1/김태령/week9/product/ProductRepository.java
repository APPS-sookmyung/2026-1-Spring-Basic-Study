package com.example.demo.product;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductRepository {
    Map<Integer, String> db = new HashMap<>();

    public String getProduct(){
        return db.get(1);
    }

    public void saveProduct() {
        db.put(1, "NoteBook");
    }
}
