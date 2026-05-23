package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Controller
public class ProductController {

    ProductController(){
        System.out.println("진짜 되나..? 진짜 스프링이 알아서 객체 생성을 하나..?");
    }
}