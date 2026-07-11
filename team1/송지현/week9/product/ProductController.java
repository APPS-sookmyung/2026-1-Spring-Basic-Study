package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
class ProductController {
    //상품 조회, 상품 등록 담당

    @Autowired // 관리하는 객체 중 이 객체 있으면 넣어달라는
    private ProductService  productService;

    ProductController(){
        System.out.println("확인");
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getProduct(){
        return productService.getProduct();
    }

    @RequestMapping(value="/product", method = RequestMethod.POST)
    public void saveProduct(){ //등록이라 반환값 없이
        productService.saveProduct();
    }

}
