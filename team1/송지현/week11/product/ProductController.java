package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
class ProductController {
    //상품 조회, 상품 등록 담당

    @Autowired // 관리하는 객체 중 이 객체 있으면 넣어달라는
    private ProductService  productService;

    ProductController(){
        System.out.println("확인");
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int id){
        return productService.getProduct(id);
    }

    @RequestMapping(value="/products", method = RequestMethod.POST)
    public void saveProduct(@RequestBody Product product){ //등록이라 반환값 없이
        productService.saveProduct(product);
    }

}
