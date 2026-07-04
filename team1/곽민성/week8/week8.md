### 이전 내용 복습: Spring MVC 구조
이전에 Spring MVC 내용을 기억해보자. Spring MVC는 역할에 따라 세 계층으로 나뉨

**Controller**는 View(사용자)와 Model 사이의 중간 매개체임. **Service**는 컨트롤러로부터 요청을 위임받아 실제 비즈니스 로직을 처리하고 데이터를 가공함. 필요한 데이터는 Repository에 요청함. **Repository**는 데이터 저장소와 직접 상호작용하며 데이터를 조회하거나 저장함.

- 요청 흐름: `Controller` → `Service` → `Repository`
         
이 구조는 선배 개발자들이 역할을 분리하는 것이 유지보수에 유리하다는 경험에서 정착된 관습임

---

## 초간단 서비스 만들어보기
`com.example.demo` 안에 `ProductService.java` 생성
![](https://velog.velcdn.com/images/cherry70/post/09d9fc6f-f965-4a31-9dd3-b3bc03f059df/image.png)

`ProductController.java`에서 이를 호출하도록 수정
![](https://velog.velcdn.com/images/cherry70/post/d6effd6c-b957-4cf1-a93e-905bf4dadc30/image.png)

결과 확인
![](https://velog.velcdn.com/images/cherry70/post/3761ccd4-4b3d-422f-b5d1-d18f7190961f/image.png)

#### 위 초기 코드의 문제점
메서드 내부에서 Service 객체를 직접 생성하면 두 가지 문제가 발생함
- 메서드를 호출할 때마다 새로운 Service 객체가 생성됨 (낭비)
- 해당 메서드 밖에서는 Service를 사용할 수 없음

> 해결책: 객체 생성을 필드로 옮기고, `@Component`와 `@Autowired`를 사용해 스프링이 객체를 관리하도록 맡김. 동일한 방식으로 `ProductRepository.java`도 생성함.

![](https://velog.velcdn.com/images/cherry70/post/8ebae713-0b9a-4c28-8ef3-af795eaa75bb/image.png)
![](https://velog.velcdn.com/images/cherry70/post/ccec5a2b-2a6f-483f-bb68-d6e2bbabf9d5/image.png)
결과 확인
![](https://velog.velcdn.com/images/cherry70/post/df927b21-b225-4460-8b5a-3e71f24b3cb6/image.png)

#### ProductRepository.java 생성
동일하게 ProductRepository.java 생성
![](https://velog.velcdn.com/images/cherry70/post/ef46057f-6096-4f1e-aba8-7827da4eb0b7/image.png)
결과 확인
![](https://velog.velcdn.com/images/cherry70/post/33c9c4ac-a4c4-4244-9817-6de8e935513d/image.png)

---
### DI 방법 3가지(위치만 다름 주의)
스프링에서 DI를 사용하는 핵심 이유는 **객체 간 결합도를 낮추고 재사용성과 테스트 용이성을 높이기 위함**임. 객체 생성과 관리를 스프링에 위임함으로써 코드 수정과 테스트가 훨씬 쉬워짐

세 방식 모두 `@Autowired`를 사용하며, 위치만 다름

1. 세터 주입 방식
`@Autowired`
`public void set ***(ProductRepository productRepository)`
   -> `public`으로 열려 있어 스프링 외의 곳에서도 접근 가능하다는 단점이 있어 현재는 잘 사용하지 않음
    
2. 필드 주입 방식
`@Autowired`
 `private ProductRepository productRepository;`
   -> 간결하지만 테스트 시 주입이 어렵다는 단점이 있음
3. 생성자 주입 방식
`@Autowired`
`ProductService(ProductRepository productRepository)`
   -> 불변성이 보장되고 테스트하기 쉬워 가장 선호되는 최신 방식. `ProductService.java`를 이 방식으로 수정하면 완성임
   
---

### ProductService.java 수정
위 DI 방법 참고해서 ProductService.java 수정
![](https://velog.velcdn.com/images/cherry70/post/37fcd7ca-9d43-46bf-8cf7-46dcdbd3ff57/image.png)
결과 확인
![](https://velog.velcdn.com/images/cherry70/post/c0ef1fb5-9b72-46f9-be17-57629328464e/image.png)
