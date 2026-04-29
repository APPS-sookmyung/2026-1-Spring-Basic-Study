Spring-Basic 스터디 (18강\~23강)



**Spring Initializr (https://start.spring.io/)**

* 스프링 부트가 웹 서버에 내장되어있음.
* Gradle - Groovy, Kotlin : Gradle쓸 때의 언어는 Groovy? Koflin?
* 버전 선택할 때 괄호 있는 건 피하고 최대한 오래된 버전으로 택하기
* Metadata : 프로젝틑 밖에서 봤을 때 보이는 것
* Packaging : 압축 후 배포할 떄 뭐로 할거야?
Jar(Java archive) or War(Web archive)
* Java버전은 17이 안정적이다.
* Dependencies: 여기서는 사용한다(뭐 사용할 거야?)
* 다 고르고 Generate 누르면 zip파일이 다운로드 되고 이걸 intellij에서 실행하면 된다.



**프로젝트 실행하기**

* 다운받은 파일 압축 풀기
* intellij에서 실행하되 build.gradle파일을 프로젝트로 연다.
* BUILD SUCCESSFUL 이라고 밑에 뜨면 완료
* src > main > java > DemoApplication파일= 실행 메소드는 미리 준비되어있음
* resources = 소스 파일이 아닌 것들의 모음 (이미지, 화면, JPA)
* build.gradle 안에 적힌 코드의 언어가 Groovy
* gradlew, gradlew.bat은 jar사용 파일
* 아무것도 없을 때 실행 잘 되는 지 체크해서 코드 오류 수정이 용이하다.



**자바의 불편한 점**

* *객체 지향 언어* 이므로 무언가를 할 때 무조건 객체가 필요함.



**스프링의 주요 원리 4가지**

&#x20;    *1. IoC (Inversion of Control) (제어의 역전)*

* inverse: 정반대로 뒤집힌다.
* control: 제어 "프로그램의 흐름 = 객체의 흐름"

  = 객체에 대한 제어권을 정반대로 뒤집는다.(개발자에게서 스프링으로 이동)



  *2. 컨테이너*

* 스프링이 객체를 생성 후 관리하는데 도움을 주는 박스
* "스프링/IoC/DI 컨테이너"
* 

  *3. 스프링 빈*

* 컨테이너의 안, 즉 스프링이 관리하는 객체



  *4. DI (Dependency Injection)(의존성 주입)*

* 의존한다 = 사용한다. 의존성 = 사용(하는)할 것 = 객체
* 개발자 = (요청하여)주입당한다(받는다)
* 스프링 = 주입해준다

  cf. 객체를 사용한다 = 객체를 생성해서 메소드/필드를 호출, 접근한다.





