> [Reference] : 위 글은 다음 내용을 제가 공부한 후, 인용∙참고∙정리하여 만들어진 게시글입니다.
- 내용:
https://inf.run/Uspgx

## 웹 개발 초기와 현재
- 프론트엔드와 백엔드 역할의 분리: 웹의 복잡성 증가와 사용자 상호작용 확대가 화면/데이터 혼합의 비효율을 낳아 역할 분리가 필요했음. 이는 개발 효율성을 높임
- 백엔드: 주로 시스템의 논리, 데이터 처리, 그리고 시스템이나 프론트엔드와 통신할 API를 만드는 역할

## API
**API(Application Programming Interface)**: 백엔드 개발자가 만드는 핵심적인 요소 중 하나. 다른 시스템이나 프론트엔드가 백엔드의 기능이나 데이터에 접근할 수 있게 해주는 '인터페이스' 역할을 함. 애플리케이션들이 서로 정해진 방식으로 상호작용을 가능하게 해줌
- API를 사용하는 주된 이유: 시스템의 복잡성을 숨기고, 데이터를 통제하여 보안을 유지하며, 사용자가 쉽게 데이터를 활용할 수 있게 장벽 역할을 함
  - Interface: 서로 마주한다. 

### API 종류
- **REST API**: HTTP 약속 잘 지키는 API
- **REST(ful) API**: 약속 정말 잘 지키는 API

## Spring Boot 프로젝트 시작하기
- 프로젝트 기반 생성: https://start.spring.io/
- 여기서 Project는 사용할 빌드 도구를 뜻함
  - 빌드(build): 소스코드가 실행되기까지의 모든 과정
- Metadata: 프로젝트를 외부에서 식별하기 위한 정보. 프로젝트 이름, 패키지 이름, 프로젝트 설명 등이 포함됨
- 배포: 사용자가 사용할 수 있도록 열어주는 것. 프로젝트를 압축해서 실행하는 형태로 만든 뒤 서버라는 사용자가 접근할 수 있는 곳에 실행시켜놓는 것
  
### 기본 세팅
- Project: Gradle - Groovy (Gradle과 대화할 언어 선택. Groovy가 가장 많이 사용됨)
- Language: Java
- Spring Boot: 3.5.14 (가장 오래된 버전 선택하면 됨) 
- Project Metadata
  - Packaging: Jar (Java archive. Java와 관련된 파일들을 모두 압축한 압축 파일)
  - Java: 17 (실무에서 쓰는 건 대다수 가장 안정된 8, 11, 17)
- Dependencies: Spring Web

![](https://velog.velcdn.com/images/cherry70/post/e32752b6-0c7c-4803-ae54-24be3ba9c583/image.png)

- Generate + .zip 압축 풀기
![](https://velog.velcdn.com/images/cherry70/post/e8d688ac-3402-4a3c-beb6-a031d3c3c059/image.png)
- 프로젝트로 열기

### 폴더 구조
  ![](https://velog.velcdn.com/images/cherry70/post/fc64aa5a-6b9d-4bb2-8b9a-aed9b17e0956/image.png)
  
- .gradle: Gradle이 사용하는 폴더. Gradle의 캐시 파일이 주로 들어있음
- build: 프로젝트가 빌드되면 생성되는 폴더
- src
  - main
    - java
      - DemoApplication: Spring Boot가 미리 생성해 둔 메인 메소드가 들어있음
    - resources: 소스 파일이 아닌 모든 파일
      - static: 이미지
      - application.properties: DB 연결 정보, 서버 포트, 외부 API 등을 작성하는 설정 파일. 민감한 정보는 직접 공개하지 않도록 주의해야 함
  - build.gradle: gradle이 build 할 때 사용하는 문서. dependencies에서 아까 추가한 Spring Boot를 확인할 수 있음
  - gradlew, gradlew.bat: Jar 파일 만들어낼 때 실행하는 파일. Mac에서는 gradlew Windows에서는 gradlew.bat 사용
  - settings.gradle: gradle이 확인하는 설정 파일

### 첫 실행
src > main > java > DemoApplication 찾아서 실행
![](https://velog.velcdn.com/images/cherry70/post/16073271-0ff2-44d8-b08b-68a76ab5f04d/image.png)
![](https://velog.velcdn.com/images/cherry70/post/aa69b967-c177-4ce4-ac0c-536d0877b593/image.png)
- 맨 밑에 Started 확인하면 성공!
