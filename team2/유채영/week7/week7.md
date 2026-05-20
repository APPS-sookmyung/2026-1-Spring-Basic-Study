# 색션 8 : Request Mapping과 RestController

## 핸들러 메서드와 HTTP Method

### 핸들러 메서드 (Handler Method)
* **개념:** 사용자의 요청(HTTP Request)이 들어왔을 때 자동으로 호출되는 메서드
* **`@RequestMapping`:** 어떤 요청이 들어왔을 때 아래의 메서드를 실행할지 매핑해 주는 역할
  * `localhost:8080`은 메인 주소이므로 생략 가능하며, 소괄호 `()` 안에 상세한 HTTP 요청 내용을 적음.

### HTTP 요청의 핵심 요소
* **URL (주소):** `@RequestMapping(value = "/path")` 형태로 매핑할 주소를 지정함.
* **Method (목적):** 데이터 연산(CRUD)의 목적에 맞는 HTTP 메서드를 지정함.
* **ResponseBody:** 처리된 결과 데이터를 담아 사용자에게 돌려줌.

### CRUD에 따른 HTTP Method 매핑
* **조회:** `GET`
* **등록/생성/삽입:** `POST`
* **수정:** `PUT`(전체 수정) / `PATCH`(부분 수정)
* **삭제:** `DELETE`
  
---

## `@Controller` vs `@RestController`

### `@Controller` (전통적인 웹 개발 방식)
* 원래 스프링은 백엔드와 프론트엔드를 모두 처리하던 풀스택 프레임워크
* 사용자의 요청에 대해 **화면(View, HTML)**을 반환하는 역할 수행.

### `@RestController` (현재의 RestAPI 방식)
* HTTP 규약을 엄격하게 잘 지키는 최신식 컨트롤러
* **구조:** `@Controller` + `@ResponseBody`
* 화면(HTML)을 반환하는 대신, **ResponseBody에 순수한 데이터**를 직접 담아서 클라이언트에게 전달함.