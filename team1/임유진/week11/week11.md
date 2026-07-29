# HTTP Body 데이터 받아오기

## HTTP Request Body와 JSON 데이터 매핑

- 상품명, 가격, 설명 등 여러 종류의 복잡한 데이터를 한 번에 보낼 때엔 HTTP Request Body에 데이터를 담아 전송해야 함
- 이때 전 세계 표준처럼 사용하는 데이터 형식이 JSON

### JSON의 특징

- JavaScript Object Notation
- 자바스크립트의 객체 표기법에서 유래한 텍스트 데이터 포맷
- `{"key": "value"}` 구조로 구성
- 구조가 단순하여 컴퓨터와 사람 모두 읽고 쓰기 편함

```java
public class Product {
    private String name;
    private int price;
    private String description;

    public String getName() { return name; }

    public int getPrice() { return price; }

    public String getDescription() { return description; }
}
```

```java
@RequestMapping(value="/products",method = RequestMethod.POST)
public void saveProduct(@RequestBody Product product) {
    productService.saveProduct(product);
}
```

```java
public void saveProduct(Product product) {
    productRepository.saveProduct(product);
}
```

```java
@Component
public class ProductRepository {
    private Map<Integer, Product> db = new HashMap<>();
    private int id = 1;

    public String getProduct(int id){
        return db.get(id).getName();
    }

    public void saveProduct(Product product) {
        db.put(id++, product);
    }
}
```

---

## 테스트 진행

<table style="width: 100%; border: none;">
  <tr style="border: none;">
    <td style="width: 50%; border: none; padding: 2px;">
      <img src="https://velog.velcdn.com/images/lyj5721/post/c9fb6e29-3687-43a7-af88-ca4f66bb87eb/image.png" width="100%">
    </td>
    <td style="width: 50%; border: none; padding: 2px;">
      <img src="https://velog.velcdn.com/images/lyj5721/post/2bb4ac2f-7423-416d-b9a9-c4bd3c71c5ab/image.png" width="100%">
    </td>
  </tr>
</table>

아래는 객체를 통채로 받아오는 코드

```java
@Component
public class ProductRepository {

    private Map<Integer, Product> db = new HashMap<>();
    private int id = 1;

    public Product getProduct(int id){
        return db.get(id);
    }

    public void saveProduct(Product product) {
        db.put(id++, product);
    }
}
```

```java
public Product getProduct(int id) {
        return productRepository.getProduct(id);
    }

```

```java
@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int id) {
        return productService.getProduct(id);
    }
```

![](https://velog.velcdn.com/images/lyj5721/post/e39bf62e-9ac4-4219-af6c-df049b0d7df0/image.png)

---

## 스프링 핵심 어노테이션 분리

- `@Controller`
  - 해당 클래스가 웹 요청을 처리하는 컨트롤러임을 명시
  - Spring MVC의 View 계층 제어 및 API 응답 담당
- `@Service`
  - 비즈니스 로직이 일어나는 계층임을 명시
  - 특별한 기술적 기능은 없으나, **"여기에 핵심 비즈니스 루틴이 있다"**는 것을 개발자와 프레임워크에 알리는 가독성적 역할이 큼
- `@Repository`
  - `@Controller` + DB 기본 예외 처리
  - 데이터 액세스 계층(DB 소통)임을 명시

```java
@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product getProduct(int id) {
        return productRepository.getProduct(id);
    }

    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

}
```

```java
@Repository
public class ProductRepository {

    private Map<Integer, Product> db = new HashMap<>();
    private int id = 1;

    public Product getProduct(int id){
        return db.get(id);
    }

    public void saveProduct(Product product) {
        db.put(id++, product);
    }
}
```
