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

    ProductController(){
        System.out.println("test");
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int id) {
//        해당 메소드를 호출할 때마다 새로운 Service 객체가 생성됨
//        이 메소드 밖에서는 Service를 쓸 수 없음
//        -> 필드로 옮기자
//        ProductService productService = new ProductService();
        return productService.getProduct(id);
    }

    @RequestMapping(value="/products",method = RequestMethod.POST)
    public void saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }
}
