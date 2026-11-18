package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
public class ProductController {
       // 클래스 이름은 구체적으로
    @Autowired
    private ProductService productService;

    ProductController(){
        System.out.println("진짜 되나..? 진짜 스프링이 알아서 객체 생성을 하나..?");
    }

    @RequestMapping(value="/products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int id){
        /**
         * 이 메소드를 호출할 때마다 새로운 Service 객체가 생성되네?
         * 이 메소드 밖에선 Service를 사용하지 못하네?
         */
        // ProductService productService = new ProductService();
        return productService.getProduct(id);
    }

    @RequestMapping(value="/products", method = RequestMethod.POST)
    public void saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
    }
}
