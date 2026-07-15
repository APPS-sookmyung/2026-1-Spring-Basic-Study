package com.example.demo.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class ProductController {
    // 상품 조회, 상품 등록 담당
    @Autowired
    private ProductService productService;

    ProductController(){
        System.out.println("진짜 되나..?");
    }

    @RequestMapping(value="/products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int id){
        /**
         * 이 메소드 호출할 때 마다 새로운 Service 객체 생성
         * 이 메소드 밖에선 Service를 못 쓴다는?
         */
        //ProductService productService = new ProductService();
        return productService.getProduct(id);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public void saveProduct(@RequestBody Product product){
        productService.saveProduct(product );
    }
}
