# Model과 DI

## Spring MVC 패턴의 역할 분담

- 웹 애플리케이션을 효율적으로 유지보수 하기 위해 역할을 3가지 계층(Layer)로 나눈 구조
- Layer: Controller, Service, Repository

### Model

- 데이터를 직접 다루고 비즈니스 로직을 처리하는 핵심 영역
- **Service(비즈니스 계층)**
  - 핵심 비즈니스 로직 수행
  - 필요한 데이터를 가져오기 위해 Repository를 호출
- **Repository**
  - DB와의 직접적인 소통 담당
  - 데이터의 CRUD 처리

---

```java
@Controller
@ResponseBody
public class ProductController {
    // 상품 조회, 상품 등록 담당

    ProductController(){
        System.out.println("test");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getProduct() {
        ProductService productService = new ProductService();
        return productService.getProduct();
    }
}
```

```java
package com.example.demo;

public class ProductService {
    public String getProduct() {
        return "NoteBook!";
    }
}

```

![](https://velog.velcdn.com/images/lyj5721/post/fbd3084b-abfe-45c2-8922-9e6fcfa3ce51/image.png)

위 코드에서 메소드 밖에서도 Service를 사용하기 위해 `@Autowired`를 이용한 의존성 주입으로 필드에 선언을 해주었음. (Filed Injection)

```java
@Controller
@ResponseBody
public class ProductController {
    // 상품 조회, 상품 등록 담당

    @Autowired
    private ProductService productService;

    ProductController(){
        System.out.println("test");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getProduct() {
//        해당 메소드를 호출할 때마다 새로운 Service 객체가 생성됨
//        이 메소드 밖에서는 Service를 쓸 수 없음
//        -> 필드로 옮기자
//        ProductService productService = new ProductService();
        return productService.getProduct();
    }
}
```

```java
@Component
public class ProductService {
    public String getProduct() {
        return "NoteBook!!";
    }
}
```

![](https://velog.velcdn.com/images/lyj5721/post/831fc421-a9d0-4cef-9c0b-9cc5c8f2e83c/image.png)

---

## Repository의 등장

```java
@Component
public class ProductRepository {
    public String getProduct(){
        return "NoteBook!!";
    }

}

```

```java
@Component
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public String getProduct() {
        return productRepository.getProduct();
    }
}
```

![](https://velog.velcdn.com/images/lyj5721/post/0f67dfc4-26dc-4e52-a862-4816c5dcd3ef/image.png)

_`@Component`를 통해 등록된 빈은 다른 곳에서 `@Autowired`를 사용해 의존성을 주입할 수 있다_

---

## DI(의존성 주입) 3가지 방법

**1. 수정자 주입 (Setter Injection)**

```java
@Autowired
public void set*** (ProductRepository productRepository)
```

- 메서드가 public으로 열려있어, 개발자가 실수로 언제든 의존 객체를 변경할 수 있는 위험 존재

**2. 필드 주입 (Filed Injection)**

```java
@Autowired // 필드 주입 방식
private ProductRepository productRepository;
```

**3. 생성자 주입 (Constructor Injection)**

```java
@Autowired //생성자 주입 방식
ProductService(ProductRepository productRepository)
```

- 최근 가장 권장되는 방식
- 객체가 생성될 때 딱 한 번만 호출 되므로 불변성을 확보할 수 있음 (`final`)

```java
@Component
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public String getProduct() {
        return productRepository.getProduct();
    }
}
```

![](https://velog.velcdn.com/images/lyj5721/post/22790569-9e19-4a6c-af94-9bd6ecdb0c7e/image.png)
