
## @Component와 스프링 빈 등록
스프링 => 클래스를 객체로 생성한 뒤 컨테이너에서 관리

어노테이션(스프링 빈으로 등록하는 대표적인 방법)의 방법

- `@Component` 사용
   - 스프링이 직접 객체를 생성하고 관리함
   - 주로 직접 만든 클래스를 빈으로 등록할 때 사용
   - @Controller, @Service, @Repository도 내부적으로 @Component를 포함하고 있음

``` js
@Component
class MyClass {
}
```
   
  
  ![](https://velog.velcdn.com/images/jihyun418/post/b9a61237-bab0-4a04-b4bb-3a34b15bac2e/image.png)
![](https://velog.velcdn.com/images/jihyun418/post/996c9f91-873c-4e5b-8278-9ee97e15ce47/image.png)

---



## Apache tomcat

스프링 부트 애플리케이션을 실행하면 로그에서 Tomcat 관련 내용을 확인할 수 있다. 

- ``Starting DemoApplication using Java 17.0.18`` 
→ DemoApplication을 Java 17로 실행하고 있다는 의미
- ``Tomcat initialized with port 8080 (http)``
→ 내장 Tomcat이 8080 포트에서 실행될 준비를 마쳤다는 의미
![](https://velog.velcdn.com/images/jihyun418/post/c8f60ac9-29e2-47f2-b701-96083cd957ce/image.png)
->spring initializr 화면

### 1. Tomcat이란?
- Apache Tomcat은 스프링 부트 애플리케이션이 웹 요청을 받을 수 있도록 도와주는 웹 애플리케이션 서버 / 인터넷 세상에 공간을 만들어준다


### 2. ``http://localhost:8080`` 의 의미
``http://localhost:8080``
- localhost : 내 컴퓨터
- 8080 : 포트 번호
= 내 컴퓨터의 8080번 통로로 실행 중인 웹 애플리케이션에 접속한다는 뜻
 
 
###  3. ERROR페이지
- 스프링 부트 서버는 정상 실행되었지만, 해당 주소에 응답할 페이지나 컨트롤러가 없으면 기본 에러 페이지가 뜬다.
- 주소를 처리하는 코드가 없다면 Whitelabel Error Page가 나타난다.

 ![](https://velog.velcdn.com/images/jihyun418/post/7d00d870-891b-4f47-9137-583533f32394/image.png)

---
## @Controller
``@Controller``는 해당 클래스를 스프링 빈으로 등록하면서,동시에 웹 요청을 처리하는 컨트롤러 역할을 하도록 표시하는 어노테이션
```js
@Controller
public class HomeController {
}
```
### **@Controller의 역할**
  - 내부를 확인해 보면 @Component를 포함 => 클래스를 스프링 빈으로 등록
  - 해당 클래스를 요청 처리용 컨트롤러로 사용
	사용법: @RequestMapping이 달려있는 handler method와 콤비다

### Handler Method
|구분|호출주체|
|---|---|
|핸들러 메소드| 사용자의 웹 요청이 들어오면 스프링이 자동 호출|
|일반 메소드| 개발자가 코드 안에서 직접 호출|
