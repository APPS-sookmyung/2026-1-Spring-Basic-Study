## `@RequestMapping` 과 `@RestController` 
#### `@Component` 는 생략 가능
`@Controller`가 이미 `@Component`를 포함하고 있기 때문에, `@Controller`를 사용할 때 `@Component`를 따로 붙이지 않아도 됨

### `@RequestMapping`
```@RequestMapping```: 사용자의 요청이 들어왔을 때 어떤 메소드를 호출할지 알려주는 역할을 함. 즉, 특정 URL과 HTTP 메서드에 맞는 요청이 들어왔을 때 어떤 메서드를 실행해야 하는지 스프링에게 알려주는 어노테이션임. **요청과 코드를 연결**해주는 역할을 한다고 이해하면 됨

![](https://velog.velcdn.com/images/cherry70/post/c3619e49-cc40-43bd-b634-a63ff837cb3c/image.png)

#### HTTP 개념 짚고 가기
- **Request(요청)**: 요청을 보내기 위해서는 다음 두 가지가 필요함. 
  - **URL**: 어디로 보낼지 (주소)
  - **Method**: 무엇을 할지 (목적)
    - `GET`: 조회
    - `POST`: 삽입/등록/생성
    - `PUT`: 전체 수정
    - `PATCH`: 부분 수정
    - `DELETE`: 삭제

- **Response(응답)**: 응답의 Body에 데이터를 담아 전달함

```value```에 들어가는 ```http://localhost:8080```은 현재 서비스의 기본(메인) 주소이므로, 이 부분은 생략해도 동작에 문제가 없다.

![](https://velog.velcdn.com/images/cherry70/post/593f9929-09a1-4fe9-9118-8c46fbf933b4/image.png)

#### 실행해보기 

![](https://velog.velcdn.com/images/cherry70/post/5fa0b400-30ac-4734-9063-d3741f355171/image.png)

-> 아직 Notebook 화면이 뜨지 않음

---
## 왜 안 될까?
여기서 사용한 `@Controller`는 사실 **예전 방식의 Controller**임. 본래 Controller는 화면(View)까지 반환하는 역할을 했고, 그 시절의 Spring은 프론트엔드와 백엔드를 모두 처리하는 **풀스택 프레임워크**였음.

반면 요즘 백엔드의 역할을 담당하는 Controller는 `@RestController`. 앞서 배운 REST의 의미를 떠올려보면, `@RestController`는 **HTTP 규칙을 잘 지키는 Controller**라고 이해할 수 있음.
![](https://velog.velcdn.com/images/cherry70/post/2376d0df-48da-4d03-aa6b-982e4e651625/image.png)


이번에도 ```command``` 눌러 ```@RestController```의 어노테이션 내부를 직접 살펴보자
![](https://velog.velcdn.com/images/cherry70/post/c579dd3f-b2ec-45db-8361-94485b00086c/image.png)

### `@RestController` 란?
```@RestController```: 즉 `@RestController`는 웹 요청을 처리하는 `@Controller`의 기능과, 메서드의 반환값을 HTTP 응답 본문(body)에 직접 넣어주는 `@ResponseBody`의 기능을 합쳐놓은 어노테이션임. 주로 REST API 개발에 사용되며, 데이터를 JSON 등의 형태로 반환할 때 편리함

이 동작 원리를 직접 눈으로 확인하기 위해, 이번에는 `@RestController` 대신 `@Controller` + `@ResponseBody` 조합을 사용해보자
![](https://velog.velcdn.com/images/cherry70/post/e7688d59-cdcc-4a60-84f3-c6c485926574/image.png)

#### 다시 실행

![](https://velog.velcdn.com/images/cherry70/post/220a2623-98ea-4936-9f18-d64a8d49217f/image.png)

-> 새로고침을 하면 이제 NoteBook이 정상적으로 뜨는것을 확인할 수 있음