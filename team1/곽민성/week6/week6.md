## Annotation의 2가지 방법
***Annotation***: 객체를 생성부터 관리까지 맡음 = 이 클래스를 이제 스프링 빈으로 관리함 = 이 클래스를 스프링 빈으로(컨테이너)에 등록해줌 = 이 클래스를 객체로 생성해서 스프링 빈으로 등록해줌

- `@Component`
    - `@Component`가 붙은 클래스의 객체가 Spring에 의해 생성되는 시점을 가장 간단하게 확인하는 밥법은?
      -> 클래스에 생성자를 만들고 안에 출력문을 넣어봄
      ![](https://velog.velcdn.com/images/cherry70/post/7f649d7c-764a-4bf0-9b2f-7e3e726df365/image.png)
      ![](https://velog.velcdn.com/images/cherry70/post/0be8455d-59e8-47a6-b94c-8e125f731840/image.png)


- `@Configuration + @Bean`
---
## Log 뜯어보기
- `Starting DemoApplication using Java 17.0.18`
  : Java 17을 사용해서 DemoApplication을 키고 있다는 의미
  - `Tomcat initialized with port 8080 (http)`
  : Tomcat이 http를 사용해서 port 8080에서 시작한다는 의미

### Apache tomcat 이란?
***Apache(비영리재단) tomcat***: 웹 서버. 인터넷 세상에서 공간을 만들어주는 녀석. 자바 웹 애플리케이션을 실행해주는 웹 서버 + 서블릿 컨테이너. 즉, 자바로 만든 웹 프로그램을 브라우저에서 접속할 수 있게 실행해주는 프로그램

### http://localhost:8080
: 내 컴퓨터에서 실행 중인 웹 서버에 접속하는 주소
![](https://velog.velcdn.com/images/cherry70/post/16830d97-18cc-4c67-b0cf-dfe70c7f8698/image.png)

- **port**: 컴퓨터 안에서 어떤 프로그램/서비스로 통신을 보낼지 구분하는 번호. 즉 인터넷 주소가 "건물 주소"라면, 포트는 "방 번호"에 가까움

--- 

## @Controller
![](https://velog.velcdn.com/images/cherry70/post/d31d694f-2d32-4b26-8cf9-cacbe8555287/image.png)
맥북이라면 `@Controller`를 `command`를 누르면서 눌러보자
![](https://velog.velcdn.com/images/cherry70/post/a134ab3e-b438-4501-a8f2-dfbf8e47d921/image.png)

`@Controller`의 역할: 스프링에게 이 클래스를 스프링 빈으로 등록한다는 것과 컨트롤러로 쓸 것을 알림
- 사용법: `@RequestMapping`이 달려있는 handler method와 콤비임

### Handler method
- ***Handler method***: 사용자의 요청에 의해 자동으로 호출되는 메소드
- **일반 메소드**: 개발자의 요청에 의해 호출되는 메소드