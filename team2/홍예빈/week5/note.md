# 5주차 학습 내용 정리
## Spring MVC 뜯어보기
### 클래스 구조(= 역할 부여)
    Model : 데이터 연산, 로직
    - DB 소통 역할(Repository) vs 로직 역할(Service)
    View : 화면 -> Frontend가 하기 때문에 우리는 이제X
    Controller : View(사용자)와 Model의 중간 매개체

### MVC
    View -> 요청 -> Controller -> 요청 -> Model
    View <- 응답 <- Controller <- 응답 <- Model
    - 우리는 Controller를 먼저 만들고 Model을 붙임

## 소리질러 갓노테이션
### 어노테이션의 역할 : "알려주기"
    1. 컴파일러에게 ex. @Override
    2. 빌드도구에게 ex. @Getter
    3. 프레임워크에게 : 아래 클래스를 스프링빈으로 관리 요청 