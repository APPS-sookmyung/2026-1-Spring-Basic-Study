섹션7

---



![spring Initializr](https://velog.velcdn.com/images/jihyun418/post/8f71f287-33dd-4344-8a3e-5112fc5d84f8/image.png)

추가한 Spring Web 확인해보면 아래 다양한 기능들이 적혀있다

### 클래스 구조 (=역할 부여)
#### Spring MVC
- V: View = 화면(프론트에서 만드는 것)
- C: Controller = View(사용자) -Model의 중간 매개체
- M: Model = 데이터 연산(= DB 소통 필요), 로직 => 너무 많은 역할을 부여받아 또 쪼갬
    - 상세 역할 : Repository(DB 소통), Service(로직)
    => 역할 분류를 통해 유지보수성을 높임!
    


#### Controller 클래스 만들기

- com.example.demo 하위에 클래스 생성
   - 클래스 이름은 추상적이고 보편적인 것이 아닌 구체적으로!
   - 객체 생성과 관리하기 위해 **스프링에게 요청**해야함!


#### 어노테이션
- 스프링에게 요청하는 언어 : **어노테이션**(자바개념)

![](https://velog.velcdn.com/images/jihyun418/post/a66bc4fc-2bb2-4193-b1cd-fbe275cccc5a/image.png)
 위 이미지를 보면 메소드를 잘못 작성하니 @Override에 빨간 줄이 그여짐

>**어노테이션 역할** 
1. 컴파일러에게 알려주기 (문법 체크해달라고) // ex. @Override
2. 빌드도구에게 알려주기 (코드 생성해달라고) // ex. @Getter
3. 프레임워크에게 알려주기  // ex. @아래 클래스를 스프링빈으로 관리해달라~ 요청