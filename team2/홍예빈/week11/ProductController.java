package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class ProductController {
    // 상품 조회, 상품 등록 담당

    @Autowired
    private ProductService productService;

    ProductController() {
        System.out.println("진짜 되나?????");
    }

    @RequestMapping(value="/products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int id) {
        // ProductService productService = new ProductService();
        return productService.getProduct(id);
    }

    @RequestMapping(value="/products", method = RequestMethod.POST)
    public void saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }
}

