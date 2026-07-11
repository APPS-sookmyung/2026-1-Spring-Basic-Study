package com.example.demo.product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    Map<Integer, String> db = new HashMap<>();

    public String getProduct(){
        return db.get(1);
    }
    public static void saveProduct() {
        db.put(1,"NoteBook");
    }
}
