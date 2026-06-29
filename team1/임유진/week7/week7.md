# HTTP 요청 매핑과 @RestController

## @RequestMapping과 핸들러 메소드

- 특정 HTTP 요청을 스프링 컨트롤러의 메서드와 매핑하기 위해 사용되는 어노테이션
- 주요 목적: 사용자가 보낸 요청 정보를 분석하여 어떤 메서드가 그 요청을 처리할지 정의

```java
@RequestMapping
    public String getProduct() {
        return "NoteBook";
    }
```

---

## HTTP Request & Response 핵심 구조

- **HTTP Request (요청): 서버에 무언가를 요구할 때 보내는 메세지**
  - URL: 주소
  - Method: 목적(조회, 삽입, 수정 등)
    1. GET: 조회 (Read)
    2. POST: 등록/생성 (Create)
    3. PUT: 전체 수정 (Update)
    4. PATCH: 일부 수정 (Update)
    5. DELETE:삭제 (Delete)
- **HTTP Response (응답): 서버가 처리 결과를 클라이언트에게 돌려주는 메세지**
  - Status Code(상태 코드): 처리 상태를 표현
  - Header (헤더): 메타데이터 (데이터 타입, 크기 등)
  - **Body(본문)**: 클라이언트가 요청한 실제 데이터 (JSON, HTML 등)

## 최신식 웹개발 @RestController

### @Controller

- 전통적인 방식
- 주로 HTML 뷰(View) 템플릿을 반환하기 위해 사용

### @RestController

- `@Controller` + `@ResponseBody`가 합쳐진 편의성 어노테이션

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
        return "NoteBook";
    }
}
```

![](https://velog.velcdn.com/images/lyj5721/post/de2e6bb5-3a01-43ba-b477-15d71c2f592f/image.png)
