# [ 섹션 4 ]
### ▷ 역할 분리
- 웹 개발 초기에는 프론트엔드/백엔드 구분이 없었다
- 웹 기능이 복잡해지고, 사용자와의 상호작용이 증가하면서 화면과 데이터 처리 역할 분리
- Front End : 화면 개발
- Back End : 로직 개발/데이터 연산. API를 만든다

### ▷ API (Application Programming Interface)
- 다른 시스템이나 프론트엔드 → 백엔드의 기능, 데이터에 접근할 수 있게 해주는 인터페이스 역할
- 시스템이 자신의 데이터를 외부 애플리케이션이나 사용자에게 제공하는 경우
- 데이터 베이스에 직접 접근 한다면?
시스템 입장: 위험하다 (악성 유저 등)
사용자 입장: 사용하기 어렵고 복잡하다
- API를 사용해 내부 시스템 구조를 숨기고, 데이터 접근을 통제해 보안과 안정성을 확보

### ▷ REST API
- HTTP 약속을 잘 지키는 API
- RESTful API : 약속을 정말 잘 지키는 API
- REST : 특정 제약 조건의 집합 (특히 HTTP의 장점 최대한 활용)

<br>

# [ 섹션 5 ]
### ▷ IntelliJ Community
- 유료 IntelliJ는 웹 서버 설치를 지원하지만, 무료인 Community 지원 X
- Spring boot는 웹 서버가 내장되어 있기 때문에, 무료 버전으로도 충분!

### ▷ Spring Initializer ( [start.spring.io](https://start.spring.io/) )
1. **project** : 빌드 도구 (빌드 = 소스코드가 실행되기 까지의 모든 과정)
    - 소스 코드 컴파일, 라이브러리, 패키징 등 일련의 과정을 자동화
    - 자바에서 사용하는 빌드 도구 : Ant → Maven → Gradle (순차적 발전)
    - 빌드 도구와 대화할 언어? groovy / kotlin (gradle-groovy 조합 추천)

2. **Spring Boot 버전**
    - (SNAPSHOT): 아직 개발이 덜 됨
    - 가능한 것 중 가장 오래된 것 선택 추천 (새로운 버전을 내는 속도가 빨라서, 최근 버전은 불안정할 수 있다)

3. **메타 데이터** : 프로젝트 이름, 설명, 패키지명 등 프로젝트 밖에서 프로젝트를 설명할 수 있는 껍데기

4. **Packaging** : 프로젝트를 만든 후 어떤 것으로 압축할 것인지
    - Jar : 웹서버를 포함한 자바와 관련된 모든 파일 압축 (더 간단하게 배포 가능)
    - War : 웹서버를 제외한 웹으로 돌아갈 수 있는 기본적인 파일들 압축
    - 배포 : 압축해서 실행가능한 형태로 만든 후, 서버에 올려놓는 것

5. **Java** 버전
    - 8, 11, 17 버전이 실무에서 가장 많이 쓰인다 (안정적)
    - Spring boot 3.x 버전들은 자바 17이상만 사용 가능

6. **Dpendency** (의존한다 ≒ 사용한다)
    - 프로젝트가 특정 기능을 사용하기 위해 라이브러리나 프레임워크에 기능적으로 기댄다는 뜻

### ▷ demo 폴더
1. **.gradle 폴더** : gradle이 임시 저장 용도로 쓰는 용도
2. **build** : 프로젝트를 빌드 하면 생성되는 폴더
3. **gradle** : gradle이 문제가 있을 때 사용
4. **src** : 소스 폴더
    - main > java > DemoApplication.java : main 함수가 존재하는, 우리가 실행할 파일
    - reources : 이미지, 화면 등 source가 아닌 파일들 (JPA 사용시에도 이용)
5. **build.gradle**: 빌드할 때 사용할 중요한 내용들. groovy 언어로 작성되어 있다
```java
dependencies {      // Spring Initializer 에서 Dependencies 에 추가한 요소 존재
	implementation 'org.springframework.boot:spring-boot-starter-web'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}
```
6. **gradlew / gradlew.bat**: 각각 iOS/Windows 에서 Jar 파일 생성시 사용
7. **settings.gradle** : 프로젝트 관련해서 설정할 것들

### ▷ External Libraries
- Gradle이 알아서 스프링 할 때 기본적으로 필요한 것들 + Java17 라이브러리 알아서 추가해줌

### ▷ DemoApplication.java 실행
- 프로젝트 하기전에 아무것도 없는 상태로 프로젝트 돌려보는 습관을 들이자!
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::               (v3.5.13)
```