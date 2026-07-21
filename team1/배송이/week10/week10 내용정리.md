# Spring-Basic-Week10

# @RequestParam과 @PathVariable

## HTTP 요청과 데이터 전달

클라이언트가 서버에 요청(Request)을 보낼 때는 다음 요소로 구성된다.

- **URL** : 요청할 주소
- **HTTP Method** : 요청의 목적
- **Body** : 서버로 전달할 데이터

### 주요 HTTP Method

| Method | 용도 |
|--------|------|
| GET | 조회 |
| POST | 등록(생성) |
| PUT | 전체 수정 |
| PATCH | 일부 수정 |
| DELETE | 삭제 |

---

## Postman이 필요한 이유

웹 브라우저는 주로 GET 요청만 쉽게 테스트할 수 있기 때문에 POST, PUT, PATCH, DELETE처럼 Body가 필요한 요청을 테스트하기 어렵다.

따라서 다양한 HTTP 요청을 직접 보내고 응답을 확인하기 위해 **Postman**을 사용한다.

---

## 데이터를 전달하는 두 가지 방법

### 1. Query String (`@RequestParam`)

Query String은 URL 뒤에 `?`를 붙여 **키=값** 형태로 데이터를 전달하는 방식이다.

#### 형식

```
주소?키=값
```

#### 예시

```
http://localhost:8080/products?name=keyboard
```

여러 개의 값은 `&`로 연결한다.

```
http://localhost:8080/products?name=keyboard&price=30000
```

### Controller

```java
@PostMapping("/products")
public void saveProduct(@RequestParam("name") String productName) {
    productService.saveProduct(productName);
}
```

받은 값은 Controller → Service → Repository 순으로 전달된다.

---

### 2. Path Variable (`@PathVariable`)

Path Variable은 URL 경로 자체에 값을 포함하여 전달하는 방식이다.

#### 형식

```
http://localhost:8080/products/{id}
```

#### 예시

```
http://localhost:8080/products/1
```

위 요청은 **1번 상품 조회**를 의미한다.

### Controller

```java
@GetMapping("/products/{id}")
public String getProduct(@PathVariable("id") int id) {
    return productService.getProduct(id);
}
```

---

## Repository 예시

```java
@Component
public class ProductRepository {

    private Map<Integer, String> db = new HashMap<>();
    private int id = 1;

    public void saveProduct(String productName) {
        db.put(id++, productName);
    }

    public String getProduct(int id) {
        return db.get(id);
    }
}
```

`id++`를 사용하면 상품이 저장될 때마다 새로운 번호가 자동으로 부여된다.

---

## @RequestParam vs @PathVariable

| 구분 | @RequestParam | @PathVariable |
|------|---------------|---------------|
| 위치 | Query String | URL 경로 |
| URL 예시 | `/products?name=mouse` | `/products/1` |
| 주 용도 | 검색 조건, 옵션 전달 | 특정 리소스 식별(ID) |
| 필수 여부 | 선택적인 값에도 사용 가능 | 반드시 필요한 값에 사용 |

### 사용 기준

- **검색 조건이나 옵션 전달** → `@RequestParam`
- **특정 데이터를 식별하는 ID 전달** → `@PathVariable`
