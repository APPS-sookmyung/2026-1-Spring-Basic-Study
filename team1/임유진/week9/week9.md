# DDD 패키지 분리와 URL 설계

## DDD

- **Domain Driven Development**
- **Domain**: 소프트웨어로 해결하고자 하는 비즈니스 요구사항의 단위(**기능 덩어리**)
- ex
  - 회원 가입, 로그인, 마이 페이지 -> 회원 서비스
  - 상품 조회, 상품 등록, 상품 삭제 -> 상품 서비스

```
product
 ㄴ ProductController
 ㄴ ProductService
 ㄴ ProductRepository
memver
user
...
```

---

## HashMap을 활용한 데이터 저장

- 실제 DB 대신 자바의 데이터 구조인 HashMap을 활용하여 데이터를 임시 저장

### Map과 HashMap

- **Key-Value 구조**: 데이터를 `Key`와 `Value` 쌍으로 저장
  - `Integer`(Key): 상품의 고유 번호
    - `String`(Value): 상품의 이름
- **Key의 중복 불가능**: 하나의 Key에는 하나의 Value만 매핑
- **빠른 조회 속도**: 데이터를 찾을 때 Key를 통해 원하는 위치를 바로 찾아가기 때문에 데이터가 아무리 많아도 조회 속도가 매우 빠름

```java
@Component
public class ProductRepository {

    Map<Integer, String> db = new HashMap<>();

    public String getProduct(){
        return db.get(1);
    }

    public void saveProduct() {
        db.put(1, "NoteBook");
    }
}
```

---

REST API URL 설계 규칙

- 경로가 나타내야 하는 가장 중요한 정보: 다루는 리소스의 종류
- 상품 조회(method=GET)
  http://localhost:8080/product
- 상품 등록(method=POST)
  http://localhost:8080/product

```java
@RequestMapping(value = "/product", method = RequestMethod.GET)
public String getProduct() {
//    해당 메소드를 호출할 때마다 새로운 Service 객체가 생성됨
//    이 메소드 밖에서는 Service를 쓸 수 없음
//    -> 필드로 옮기자
//    ProductService productService = new ProductService();
    return productService.getProduct();
}

@RequestMapping(value="/product",method = RequestMethod.POST)
public void saveProduct() {
    productService.saveProduct();
}

```

URL 주소는 동일하게 `/product`로 유지되면서 들어오는 HTTP 메서드 방식에 따라 조회와 등록 기능이 깔끔하게 분기되도록 설계
