# Request Body와 JSON

## 1. Request Body를 이용한 데이터 전달

클라이언트는 서버에 요청을 보낼 때 URL뿐만 아니라 **Request Body**에 데이터를 담아 전달할 수 있다.

Spring에서는 `@RequestBody`를 사용하여 Request Body에 포함된 JSON 데이터를 자바 객체(Java Object)로 자동 변환한다.

### `@RequestBody`란?

`@RequestBody`는 HTTP 요청 본문에 들어 있는 JSON 데이터를 자바 객체와 매핑해 주는 애너테이션이다.

예를 들어 다음과 같은 JSON을 전송했다고 가정하자.

```json
{
  "name": "handcream",
  "price": 15000,
  "description": "촉촉"
}
```

이를 받을 자바 클래스는 다음과 같이 작성할 수 있다.

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

JSON의 **키(key)**와 자바 객체의 **필드명**이 일치하면 Spring이 자동으로 값을 연결해 준다.

### 동작 과정

```text
클라이언트(JSON)
        │
        ▼
HTTP Request Body
        │
        ▼
@RequestBody
        │
        ▼
Java 객체(Product)
```

---

# JSON(JavaScript Object Notation)

## JSON이란?

JSON(JavaScript Object Notation)은 데이터를 주고받을 때 가장 많이 사용하는 데이터 형식이다.

데이터는 **Key-Value** 형태로 구성되며, 사람이 읽기 쉽고 다양한 언어에서 사용할 수 있다는 장점이 있다.

### JSON 예시

```json
{
  "name": "handcream",
  "price": 15000,
  "description": "촉촉"
}
```

JavaScript에서는 점(`.`) 표기법을 사용해 각 데이터를 가져올 수 있다.

```javascript
product.name;
product.price;
product.description;
```

> JSON은 JavaScript 객체와 형태는 비슷하지만, 문자열 규칙 등에서 차이가 있는 별도의 데이터 표현 방식이다.

---

# Component와 스테레오타입 애너테이션

## `@Component`

`@Component`는 스프링이 객체를 Bean으로 등록하기 위해 사용하는 가장 기본적인 애너테이션이다.

컴포넌트 스캔(Component Scan) 대상이 되며, 스프링 컨테이너가 객체를 생성하고 관리한다.

### 주요 스테레오타입 애너테이션

스프링에서는 역할에 따라 `@Component`를 확장한 애너테이션을 제공한다.

- `@Controller` : 사용자 요청을 처리하는 컨트롤러 계층
- `@Service` : 비즈니스 로직을 담당하는 서비스 계층
- `@Repository` : 데이터베이스 접근을 담당하는 저장소 계층

이 애너테이션들은 모두 내부적으로 `@Component`를 포함하고 있으므로, 컴포넌트 스캔 대상이 되어 스프링이 Bean으로 등록한다.