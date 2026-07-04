## Model
- **Service**
    - 컨트롤러로부터 위임 받아 비즈니스 로직 처리, 데이터 가공
    - 필요한 데이터는 레포지토리에게 요청한 후 받아서 사용
- **Repository**
    - 데이터 관리/DB소통 (데이터 조회 및 저장)

```java
@Controller
@ResponseBody
public class ProductController {       // 상품 조회, 상품 등록 담당 컨트롤러
    ... 
    @RequestMapping(value="", method= RequestMethod.GET)
    public String getProduct() {
        ProductService productService = new ProductService();
        return productService.getProduct();
    }
}
```

- 문제점 :
    - 컨트롤러의 getProduct 메서드를 호출할 때마다 Service 계속 생성
    - 또한, 생성된 Service를 메서드 밖에서는 사용할 수 없다
    - → Controller의 필드로 옮기자!

```java
@Controller
@ResponseBody
public class ProductController {       // 상품 조회, 상품 등록 담당 컨트롤러
    // 필드
    @Autowired        // DI 요청
    private ProductService productService;
    ...
}
```

## DI(의존성 주입) 방법은 사실 3가지
1. setter 주입 방식 
```java
@Autowired
public void set*** (ProductRepository productRepository)
```
- public으로 선언되어 있기 때문에 개발자 외에도 접근 가능하다는 단점 존재
2. 필드 주입 방식
```java
@Autowired
private ProductRepository productRepository;
```
3. **생성자 주입 (현재 가장 선호되는 방식)**
```java
@Autowired
ProductService (ProductRepository productRepository)
```

- DI 사용 이유
    - 객체 간의 결합도를 낮추고, 재사용성 및 테스트 용이성을 높인다.