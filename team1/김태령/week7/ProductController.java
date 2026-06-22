package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class ProductController {
       // 클래스 이름은 구체적으로

    ProductController(){
        System.out.println("진짜 되나..? 진짜 스프링이 알아서 객체 생성을 하나..?");
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public String getProduct(){
        return "NoteBook";
    }
}
