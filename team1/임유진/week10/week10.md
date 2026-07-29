# @RequestParam과 @PathVariable

## HTTP Method

- Request
  - URL: 주소
  - Method: 목적
  - Body: 데이터의 내용
- HTTP Method
  1. 조회: GET
  2. 등록/생성/삽입: POST
  3. 수정: (전체)PUT / (부분)PATCH
  4. 삭제: DELETE

---

## POSTMAN으로 테스트하기

![](https://velog.velcdn.com/images/lyj5721/post/701162ad-032e-46f6-b29d-01ee4a60e07d/image.png)

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

## 상품명 받아오기 - 데이터 받기

### 1. 쿼리 스트링 (Query String)

- 주소에 데이터를 받아오는 방법
- `http://localhost:8080/products?name=___`
- name에 상품명을 넣어 전달하는 방법

```java
@RequestMapping(value="/product",method = RequestMethod.POST)
public void saveProduct(@RequestParam(value="name") String productName) {
    productService.saveProduct(productName);
}
```

```java
public void saveProduct(String productName) {
    productRepository.saveProduct(productName);
}
```

```java
public void saveProduct(String productName) {
    db.put(1, productName);
}
```

![](https://velog.velcdn.com/images/lyj5721/post/82e739c5-3e63-4a36-b0f0-89f87543615f/image.png)

![](https://velog.velcdn.com/images/lyj5721/post/b5a130d1-94f4-405d-901e-579899db495c/image.png)

```java
@Component
public class ProductRepository {

    private Map<Integer, String> db = new HashMap<>();
    private int id = 1;

    public String getProduct(){
        return db.get(1);
    }

    public void saveProduct(String productName) {
        db.put(id++, productName);
    }
}
```

id값을 부여하여 여러 개의 상품을 등록할 수 있도록 구현

### 2. 경로 변수 (Path Variable)

- 주소에 데이터를 받아오는 방법
- `http://localhost:8080/products/{id}`
- 경로를 지정하는 변수를 사용

```java
@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
public String getProduct(@PathVariable("id") int id) {
    return productService.getProduct();
}
```

<table style="width: 100%; border: none;">
  <tr style="border: none;">
    <td style="width: 50%; border: none; padding: 2px;">
      <img src="https://velog.velcdn.com/images/lyj5721/post/9451fe0d-6d4b-450c-bc49-e559e8039fa8/image.png" width="100%">
    </td>
    <td style="width: 50%; border: none; padding: 2px;">
      <img src="https://velog.velcdn.com/images/lyj5721/post/27e7a50a-b6e3-483e-a924-ad158f549492/image.png" width="100%">
    </td>
  </tr>
</table>
