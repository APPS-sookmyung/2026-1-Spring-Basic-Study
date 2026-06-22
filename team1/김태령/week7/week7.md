#Spring-Basic-Week7

## Request
Request는 웹 공간에 접근하기 위한 HTTP 요청
HTTP 요청 시 필수로 필요한 두 가지 핵심 요소

### 1. URL

URL은 요청을 보낼 주소를 의미

### 2. HTTP Method

HTTP Method는 요청의 목적을 의미

예를 들어 조회, 삽입, 수정, 삭제와 같은 목적을 구분할 수 있음

| 목적           | HTTP Method |
| ------------ | ----------- |
| 조회           | GET         |
| 등록 / 생성 / 삽입 | POST        |
| 수정           | PUT / PATCH |
| 삭제           | DELETE      |

수정의 경우 PUT과 PATCH를 사용할 수 있음

| HTTP Method | 의미    |
| ----------- | ----- |
| PUT         | 전체 수정 |
| PATCH       | 부분 수정 |

---

## Response

Response는 HTTP 요청에 대한 응답

## Body

Body는 데이터를 담아서 돌려주는 부분

---

## @Controller

`@Controller`는 스프링에서 웹 요청을 처리하는 기능을 가진 어노테이션

```java
@Controller
public class ProductController {
}
```

즉, `ProductController` 클래스가 웹 요청을 처리하는 컨트롤러 역할을 하게 됨

---

## @ResponseBody

`@ResponseBody`는 메서드의 반환값을 HTTP 응답 본문에 직접 넣어주는 어노테이션

```java
@ResponseBody
public class ProductController {
}
```

따라서 `getProduct()` 메서드가 `"NoteBook"`이라는 문자열을 반환하면, 이 값이 응답 Body에 직접 담겨서 전달됨

```java
public String getProduct(){
    return "NoteBook";
}
```

---

## @RestController

`@RestController`는 스프링에서 웹 요청을 처리하는 `@Controller` 기능과 메서드의 반환값을 HTTP 응답 본문에 직접 넣어주는 `@ResponseBody` 기능을 합쳐놓은 어노테이션

즉, 아래 두 어노테이션을 함께 사용하는 것과 비슷한 역할을 함

```java
@Controller
@ResponseBody
```

주로 REST API 개발에 사용됨

---

## @RequestMapping

스프링 컨트롤러 클래스 내의 특정 메서드 위에 `@RequestMapping` 어노테이션을 붙이는 주요 목적은 어떤 사용자 요청이 이 메서드를 호출할지 정의하는 것

```java
@RequestMapping(value="", method = RequestMethod.GET)
public String getProduct(){
    return "NoteBook";
}
```

HTTP Method가 GET인 요청이 들어왔을 때 `getProduct()` 메서드가 호출되도록 정의한 것
