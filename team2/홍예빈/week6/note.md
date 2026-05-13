# 6주차 학습 내용 정리
## @Component 
### IoC 2가지 방법
    1. @Component
    2. @Configuration + @Bean

## Apache tomcat
### Apache tomcat
    웹 서버, 인터넷 세상에서 공간을 만들어주는 역할
    어디에 공간을 만드는가? 내 컴퓨터(localhost)
### port 항구
    원하는 서비스마다 port를 따로 두어 서비스마다 접속을 다른 항구로 하게 함
    https://localhost:8080

## @Controller의 등장
### @Controller
    클래스를 스프링 빈으로 등록하고 컨트롤러로 사용
    사용법 : @RequestMapping 이 달려있는 handler method
### handler
    사용자의 요청에 의해 자동으로 호출되는 메소드
    cf. 일반 메소드 : 개발자의 요청에 의해 호출
    