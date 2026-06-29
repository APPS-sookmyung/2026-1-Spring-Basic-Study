


## 1. 핸들러 메소드란?

**핸들러 메소드**는 사용자의 요청을 처리하는 메소드
=> 사용자가 특정 URL로 요청을 보내면 그 요청을 받아서 실행되는 메소드

Spring에서는 메소드가 사용자의 요청에 의해 호출될 수 있도록 `@RequestMapping`을 사용한다.

```java
@RequestMapping
public String getProduct() {
    return "NoteBook";
}
```

`@RequestMapping`을 붙이면 해당 메소드는 요청을 처리할 수 있는 메소드가 된다.

---

## 2. HTTP 요청과 응답

사용자가 서버에 요청할 때는 HTTP 규칙을 따라야 한다.

### Request 요청

요청할 때 필요한 정보 크게 두 가지

```text
1. URL: 요청을 보낼 주소
2. Method: 요청의 목적
```

예를 들어 상품을 조회할 것인지, 등록할 것인지, 수정할 것인지에 따라 HTTP Method가 달라진다.

### Response 응답

서버는 사용자의 요청을 처리한 뒤 결과를 다시 보내준다.
이때 데이터는 주로 **Response Body**에 담겨 전달된다.

---

## 3. HTTP Method

HTTP Method는 요청의 목적을 나타낸다.
CRUD 기능과 연결해서 생각하면 이해하기 쉽다.

| 기능      | HTTP Method | 의미           |
| ------- | ----------- | ------------ |
| 조회      | GET         | 데이터를 가져옴     |
| 등록 / 생성 | POST        | 새로운 데이터를 추가함 |
| 수정   | (전체)PUT, (부분)PATCH         | 데이터를 전체, 일부 수정함  |
| 삭제      | DELETE      | 데이터를 삭제함     |

---

## 4. @RequestMapping 사용법

`@RequestMapping`의 소괄호 안에는 요청 경로와 HTTP Method를 작성할 수 있다.

```java
@RequestMapping(value = "/products", method = RequestMethod.GET)
public String getProduct() {
    return "NoteBook";
}
```

`value` = 요청 주소의 경로 
`method`= 어떤 HTTP Method 요청을 처리할 것인지

*주의할 점은 `value`에 보통 전체 주소를 쓰지 않는다는 것

```java
// 보통 이렇게 작성하지 않음
@RequestMapping(value = "http://localhost:8080", method = RequestMethod.GET)
```

대신 서버 주소인 `http://localhost:8080`은 기본 주소로 생각하고,
코드에서는 그 뒤에 붙는 경로만 작성한다.

```java
@RequestMapping(value = "/", method = RequestMethod.GET)
public String getProduct() {
    return "NoteBook";
}
```

이 경우 사용자가 다음 주소로 요청하면 메소드가 실행된다.

```text
http://localhost:8080/
```

---

## 5. @Controller

Spring에서는 컨트롤러를 만들 때 `@Controller` 또는 `@RestController`를 사용할 수 있다.

### @Controller

- 전통적인 방식의 컨트롤러
- 주로 화면을 반환할 때 사용

Spring은 예전에는 백엔드 역할뿐만 아니라 화면까지 함께 처리하는 풀스택 프레임워크로 사용되었다.
그래서 `templates` 폴더에 HTML 같은 화면 파일을 넣고, 컨트롤러가 화면을 반환하기도 했다.

```java
@Controller
public class ProductController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getProduct() {
        return "NoteBook";
    }
}
```

하지만 `@Controller`만 사용하면 문자열을 데이터로 반환하는 것이 아니라, 화면 이름으로 인식할 수 있다. 따라서 아래와 같이 아직까지 에러 페이지가 뜨는 것을 확인할 수 있다.
   ![](https://velog.velcdn.com/images/jihyun418/post/a625eb1c-8a34-4e76-b362-1609a78c2896/image.png)

---

## 6. @ResponseBody

`@ResponseBody`는 메소드의 반환값을 화면 이름이 아니라 **응답 데이터**로 보내도록 해준다.

```java
@Controller
public class ProductController {

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getProduct() {
        return "NoteBook";
    }
}
```

이렇게 하면 `"NoteBook"`이라는 문자열이 Response Body에 담겨 클라이언트에게 전달된다.

---

## 7. @RestController

`@RestController`는 REST API를 만들 때 사용하는 컨트롤러이다.

`@RestController`는 아래 두 가지가 합쳐진 형태

```text
@Controller + @ResponseBody = @RestController
```

따라서 `@RestController`를 사용하면 메소드마다 `@ResponseBody`를 따로 붙이지 않아도 된다.

```java
@RestController 
public class ProductController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getProduct() {
        return "NoteBook";
    }
}
```

이 코드는 사용자가 `http://localhost:8080/`로 GET 요청을 보냈을 때
`NoteBook`이라는 데이터를 응답으로 돌려준다.
![](https://velog.velcdn.com/images/jihyun418/post/057291b3-5e73-4749-b32d-5c26f2552727/image.png)

---

## 8. 정리

![](https://velog.velcdn.com/images/jihyun418/post/1222270f-a918-4393-a666-03f685f3f545/image.png)
```text
핸들러 메소드
→ 사용자의 요청을 처리하는 메소드

@RequestMapping
→ 특정 URL과 HTTP Method 요청을 메소드와 연결해주는 어노테이션

HTTP Method
→ 요청의 목적을 나타냄
→ GET, POST, PUT, PATCH, DELETE

@Controller
→ 주로 화면을 반환하는 컨트롤러

@ResponseBody
→ 반환값을 응답 데이터로 보내줌

@RestController
→ REST API용 컨트롤러
→ @Controller + @ResponseBody
```

REST API를 만들 때는 보통 `@RestController`를 사용하고,
요청 주소와 목적은 `@RequestMapping`으로 연결한다.













 