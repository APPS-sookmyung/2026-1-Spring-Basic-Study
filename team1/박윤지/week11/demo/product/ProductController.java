package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody       // 컨트롤러인데, ResponseBody에 데이터를 담아서 반환할 것!
public class ProductController {       // 상품 조회, 상품 등록 담당 컨트롤러
    // 필드
    @Autowired        // DI 요청
    private ProductService productService;

    ProductController() {              // 생성자
        System.out.println("really?"); // 객체가 진짜 생성됐는지 확인
    }

    // 아래에 다가오는 메소드를, 개발자가 아니라 사용자에 의해 호출되도록 만들 수 있다!
    // localhost:8080 요청에 대한 메서드를 지정하려면?
    // localhost:8080 은 이 서비스의 메인 주소이기 때문에 생략이 가능하다! 즉, 기본 값이 localhost:8080인 것.
    // 상품 조회
    @RequestMapping(value="/products/{id}", method= RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int id) {
        /* 컨트롤러의 getProduct 메서드를 호출할 때마다 Service 계속 생성
        또한, 생성된 Service를 메서드 밖에서는 사용할 수 없다
        -> Controller의 필드로 옮기면 안되나?
        * */
        // ProductService productService = new ProductService();
        return productService.getProduct(id);
    }

    // 상품 등록
    // http://localhost:8080/products에서 localhost:8080 까지는 서비스의 메인주소이므로 생략 가능
    @RequestMapping(value="/products", method = RequestMethod.POST)
    public void saveProduct(@RequestBody Product product) {       // 매개변수로 상품명
        productService.saveProduct(product);
    }
}
