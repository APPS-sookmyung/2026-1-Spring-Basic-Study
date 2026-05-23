#Spring-Basic-Week6

## 1. Spring Bean으로 등록하는 방법 2가지
* @Component
* @Configuration + @Bean

## 2. @Component
* 클래스 위에 `@Component` Annotation을 붙이면 Spring에게 클래스를 객체로 생성해서 Spring Bean으로 등록하고 관리하라고 지시하는 것
> 즉, `@Component`가 붙은 클래스는 Spring이 자동으로 객체 생성 및 관리

## 3. `@Component` 객체 생성 확인 방법
`@Component`가 붙은 클래스의 객체가 실제로 생성되는지 확인하려면 생성자에 출력문을 넣어보면 됨
```java
@Component
class MemberService {

    public MemberService() {
        System.out.println("MemberService 객체 생성됨");
    }
}
```

Spring Boot를 실행했을 때 콘솔에 다음 문장이 출력되면,

```text
MemberService 객체 생성됨
```

Spring이 해당 클래스를 객체로 생성했다는 뜻

## 4. Tomcat initialized with port 8080
Spring Boot를 실행하면 콘솔에 다음과 같은 문구가 나옴

```text
Tomcat initialized with port 8080 (http)
```

이 뜻은 Tomcat이 실행되었고, **8080번 포트에서 웹 요청을 받을 준비가 되었다**는 의미

## 5. Apache Tomcat이란?
* **Apache Tomcat**은 Java 웹 애플리케이션을 실행해주는 서버
* Spring Boot에서는 기본적으로 내장 Tomcat을 사용
* Tomcat을 따로 설치하지 않아도 Spring Boot 프로젝트를 실행하면 Tomcat이 함께 실행됨

## 6. localhost와 port
Spring Boot를 실행한 뒤 보통 아래 주소로 접속

```text
http://localhost:8080
```

각각의 의미는 다음과 같음

```text
localhost = 내 컴퓨터
8080 = 포트 번호
```

즉,

```text
http://localhost:8080
```

내 컴퓨터에서 실행 중인 8080번 웹 서버로 접속한다는 뜻

포트는 쉽게 말해 **입구 번호** 또는 **항구 번호**

## 7. @Controller
```java
@Controller
public class HomeController {

}
```

`@Controller`는 Spring에게 다음과 같이 알려주는 Annotation

> 이 클래스를 Spring Bean으로 등록하고, 웹 요청을 처리하는 컨트롤러로 사용할게.

즉, `@Controller`는 단순히 Bean 등록만 하는 것이 아니라,  
**사용자의 웹 요청을 처리하는 역할**까지 포함

## 8. 일반 메소드와 Handler Method 차이
### 일반 메소드

일반 메소드는 개발자가 직접 호출

```java
hello();
```

즉, 개발자의 코드에 의해 실행됨

### Handler Method
Handler Method는 사용자의 웹 요청에 의해 Spring이 자동으로 호출

```java
@RequestMapping("/hello")
public String hello() {
    return "hello";
}
```

사용자가 브라우저에서 아래 주소로 접속하면,

```text
http://localhost:8080/hello
```

Spring이 자동으로 `hello()` 메소드를 실행
