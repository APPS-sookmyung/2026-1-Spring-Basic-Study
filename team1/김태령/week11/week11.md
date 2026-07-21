#Spring-Basic-Week11

## 1. 요청할 때 데이터를 함께 전달하는 방법

클라이언트가 서버로 요청을 보낼 때, 요청 본문인 **Request Body**에 데이터를 담아 전달할 수 있음.

JSON 데이터를 자바 객체로 변환하여 받기 위해 `@RequestBody` 애너테이션을 사용.

### `@RequestBody`

`@RequestBody`는 JSON과 같은 구조화된 데이터를 자바 객체로 자동 변환해 주는 애너테이션.

JSON 형태로 데이터를 보냄.

```json
{
  "name": "handcream",
  "price": 15000,
  "description": "촉촉"
}
```

JSON 데이터의 속성 이름과 자바 객체의 필드 이름이 일치하면 Spring이 자동으로 값을 매핑.

```java
public class Product {

    private String name;
    private int price;
    private String description;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
```

### 데이터 변환 과정

```text
JSON 데이터
        ↓
HTTP Request Body
        ↓
@RequestBody
        ↓
자바 객체로 변환
```

---

## 2. JSON이란?

JSON은 **JavaScript Object Notation**.
JSON은 기본적으로 **키와 값의 쌍(Key-Value)**으로 데이터를 표현.

### JSON 예시

```json
{
  "name": "handcream",
  "price": 15000,
  "description": "촉촉"
}
```

객체 내부의 값은 점 표기법을 사용해 가져올 수 있음.

```javascript
product.name;
product.price;
product.description;
```

> JavaScript 객체와 JSON은 형태가 비슷하지만 완전히 같지는 않음.

---

## 3. `@Component`와 주요 스테레오타입 애너테이션

`@Component`는 스프링에서 컴포넌트 스캔 대상이 되는 가장 기본적인 애너테이션.

`@Controller`, `@Service`, `@Repository`는 모두 `@Component`를 기반으로 만들어진 애너테이션.



