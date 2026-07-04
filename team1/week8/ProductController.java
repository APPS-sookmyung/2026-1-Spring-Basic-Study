package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody      
public class ProductController {       
    // 필드
    @Autowired       
    private ProductService productService;

    ProductController() {              // 생성자
        System.out.println("really?"); // 객체가 진짜 생성됐는지 확인
    }

    @RequestMapping(value="", method= RequestMethod.GET)
    public String getProduct() {
        return productService.getProduct();
    }
}