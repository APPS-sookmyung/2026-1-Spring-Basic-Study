### 섹션4

---
#### 웹의 과거와 현재
|과거|현재
|--|--|
|정보 조회 기능이 목적이라 그걸 한 사람이 만드는 것이 가능했음| 사용자가 데이터를 수정, 삭제, 추가할 수 있는 기능이 생기고 틀은 같은데 데이터만 달라지는 현상이 생김, 그러면서 화면 개발과 로직 개발을 따로 나눠 개발하게 됨|


- 프론트앤드 = 화면 개발
- 백앤드 = 로직/데이터 개발

---

#### API 
**= Application Programming Interface**

Interface : 서로 마주한다.

> **API 사용없이** 사용자가 직접 접근 가능하면 생기는 **문제점**
- 사용자가 내부 정보를 마음대로 수정
- 사용자는 내부에 필요 데이터 외의 정보들까지 공부해서 찾아야함

**API는 웹사이트 내에서 가능한 범위 안에서 요청과 응답을 사용자가 쉽게 받고 보낼 수 있도록 해주는 역할**

- REST(ful) API
: HTTP 약속을 잘 지키는 API 





### 섹션5

---

Intellij 엔진 설치

---

#### 스프링 부트 프로젝트 기반 생성 (Spring Initializr)

https://start.spring.io/

![](https://velog.velcdn.com/images/jihyun418/post/cee85251-5252-4857-8c62-3c33a165cf27/image.png)

- Project : 빌드 도구 선택 (Gradle이 가장 최신)
- Language : Java
- Spring Boot : 버전 (괄호 있는 버전은 오류 많음)
- Project Metadata : 패키지 이름, 프로젝트 이름과 설명
    - Packaging : 프로젝트 압축 타입 (Jar : 자바 아카이브(내장 웹 서버까지 포함하여 단일 실행 파일), War: 웹 아카이브)
    - Java : 자바 버전(8,11,17 가장 안정화되어 있음)
- Dependencies : 다른 라이브러리나 프레임워크 기능을 사용

GENERATE 클릭 후 Zip 다운

---

![](https://velog.velcdn.com/images/jihyun418/post/f561c1ae-375f-4a08-a98c-14e8f9bcd48a/image.png)

- src
  - main
      - java 
      - DemoApplication : 메인메소드 존재, 자바프로젝트 실행하는 곳
  -  resources : 소스파일이 아닌 것들의 모음 (이미지, 화면, JPA(스프링이랑  DB연결))
      - application.properties : 설정파일 (DB, 비번, 계정 작성하는 곳)
            
- build.gradle : 그레이들이 빌드할 때 사용하는 문서 (Groovy언어로 작성됨), Dependencies에서 추가한 것 확인 가능
- settings.gradle : Gradle이 확인하는 파일 (프로젝트 관련 설정 파일)


자바 실행을 위해선 **main 메소드 찾아서 실행**!


### 섹션 6

---
#### 스프링의 주요 원리

> **자바의 불편함 점**
: 객체 지향 언어 
로직만 짜는게 아닌 객체가 필요하기 때문에 객체의 라이프사이클 관리와 의존성 처리까지 신경써야 함! 



**주요원리**

- IoC
	: Inversion of Control(제어의 역전) / 프로그램의 흐름 = 객체의 흐름
    - 객체의 제어권을 스프링이 가져감

- 컨테이너
	- 스프링이 객체를 생성하고 관리하기 위해 담아두는 박스
    - 스프링/IoC/DI 컨테이너 등등으로 불림

- 스프링빈
	- 스프링이 컨테이너 안에서 관리하는 객체를 스프링빈이라고 부름
    
- DI
	: Dependency Injection (의존성 주입) / 의존성(사용할 것) = 객체
	- 개발자가 객체를 주입받음 (스프링에게 객체 주입 요청)
  
 객체 사용이란? 객체 생성해서 메소드/ 필드 호출과 접근한다.
 