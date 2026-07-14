Spring Basic Week 7

HTTP란?

HTTP(HyperText Transfer Protocol)는 클라이언트와 서버가 데이터를 주고받기 위한 통신 규약이다.

사용자가 브라우저에서 웹사이트에 접속하면 Request(요청)를 보내고, 서버는 Response(응답)를 반환한다.

⸻

HTTP Request

HTTP 요청은 크게 URL과 HTTP Method로 구성된다.

URL

요청을 보낼 주소를 의미한다.

예시

http://localhost:8080/products

HTTP Method

요청의 목적을 나타낸다.

기능	Method
조회	GET
생성	POST
수정	PUT / PATCH
삭제	DELETE

PUT과 PATCH의 차이

* PUT : 전체 수정
* PATCH : 일부 수정

⸻

HTTP Response

서버가 요청을 처리한 결과를 반환하는 것이다.

Response는 일반적으로 다음과 같은 요소로 구성된다.

* Status Code
* Header
* Body

Body

클라이언트에게 전달할 실제 데이터를 담는 공간이다.

⸻

@Controller

스프링에서 해당 클래스가 웹 요청을 처리하는 컨트롤러임을 나타낸다.

@Controller
public class ProductController {
}

스프링은 해당 클래스를 컨트롤러로 등록하여 관리한다.

⸻

@ResponseBody

메서드의 반환값을 HTTP Response Body에 직접 담아주는 어노테이션이다.

@ResponseBody
public String getProduct() {
    return "NoteBook";
}

위 코드가 실행되면 브라우저에는

NoteBook

이 출력된다.

⸻

@RestController

REST API 개발에서 주로 사용하는 어노테이션이다.

@RestController
public class ProductController {
}

실제로는 아래와 같은 의미를 가진다.

@Controller
@ResponseBody

즉,

* 웹 요청 처리
* 반환값을 Response Body에 저장

두 기능을 함께 수행한다.

⸻

@RequestMapping

특정 요청을 어떤 메서드가 처리할지 지정하는 어노테이션이다.

@RequestMapping(value = "", method = RequestMethod.GET)
public String getProduct() {
    return "NoteBook";
}

위 코드는 GET 요청이 들어왔을 때 getProduct() 메서드를 실행하도록 설정한 것이다.

즉, 요청과 메서드를 연결해주는 역할을 한다.

⸻

정리

* HTTP는 Request와 Response로 동작한다.
* Request는 URL과 Method를 포함한다.
* Response는 Body에 데이터를 담아 반환한다.
* @Controller는 요청을 처리하는 클래스이다.
* @ResponseBody는 반환값을 응답 본문에 담아준다.
* @RestController는 @Controller + @ResponseBody이다.
* @RequestMapping은 특정 요청을 메서드와 연결해준다.