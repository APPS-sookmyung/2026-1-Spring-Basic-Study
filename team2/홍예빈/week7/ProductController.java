package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ProductController {
    // 상품 조회, 상품 등록 담당

    ProductController() {
        System.out.println("진짜 되나?????");
    }

    @RequestMapping(value="", method=RequestMethod.GET)
    public String getProduct() {
        return "NoteBook";
    }
}

