package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Controller
public class ProductController {
       // 클래스 이름은 구체적으로

    ProductController(){
        System.out.println("진짜 되나..? 진짜 스프링이 알아서 객체 생성을 하나..?");
    }
}
