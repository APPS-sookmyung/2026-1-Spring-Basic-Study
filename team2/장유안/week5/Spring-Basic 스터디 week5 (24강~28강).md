Spring-Basic 스터디 week5 (24강\~28강)



**프로젝트 주제**: 상품 조회/등록 API프로젝트

* Sprint Web -> web build, REST API 사용 도움, Spring MVC사용



**Spring MVC**

* 클래스 구조 = 역할 부여
* V= view(화면), 그런데 이건 이제 프론트엔드(React)가 합니다.
* C= controller : View(사용자)- Model 중간 매개체
* M = model : 데이터 연산, 로직( DB 소통, 로직)
* Model을 쪼개면 Repository, Service
* = "프로젝트는 유지 보수를 위해 노력해야 한다!"



view의 요청을 controller가 받고 이를 Model에게 전달

model의 응답을 controller가 받아 view에 응담

\-> controller은 view와 model의 매개체 역할

\-> view는 일단 배제.  controller부터 시작!



**Controller**

* 클래스는 범용적인 이름 지양



**어노테이션**

* 스프링에게 말을 걸 수 있는 방법
* 어노테이션의 역할:  "알려주기"
1. 컴파일러에게 ex) @Override
2. 빌드도구에게 ex) @Getter
3. 프레임워크에게 ex) @스프링아..나 아래 클래스를 스프링비으로 네가 좀 관리해줘..

&#x20;               

