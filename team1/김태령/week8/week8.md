#Spring-Basic-Week8

## 1. Spring MVC 레이어별 역할 및 흐름

스프링 MVC 패턴에서 **Model(모델)**은 데이터 연산, 비즈니스 로직 처리, 데이터베이스와의 소통을 담당.

Spring에서는 이 Model 영역을 보통 다음과 같이 세분화해서 사용.

* **Service 레이어**
* **Repository 레이어**

전체적인 흐름은 다음과 같음.

```text
Controller → Service → Repository → Database
```

---

## 2. Service 레이어

### 역할

**Service 레이어**는 데이터를 활용하여 실제 연산, 가공, 핵심 비즈니스 규칙을 처리하는 계층.

즉, 단순히 데이터를 가져오는 것이 아니라 애플리케이션에서 필요한 **비즈니스 로직**을 담당.

### 특징

* 데이터를 직접 DB에서 가져오지 않음.
* DB 접근이 필요할 경우 Repository 레이어에 요청함.
* Controller와 Repository 사이에서 중간 역할을 함.

---

## 3. Repository 레이어

### 역할

**Repository 레이어**는 데이터 소스, 주로 데이터베이스와의 통신 및 데이터 관리를 담당하는 계층.

Service 레이어의 요청을 받아 실제 데이터 저장, 조회, 수정, 삭제 작업을 수행.

### 특징

* DB와 직접 소통.
* 데이터 저장, 조회, 수정, 삭제를 담당.
* Service 레이어에서 필요한 데이터를 제공.

---

## 4. 의존성 주입 Dependency Injection, DI

### DI란?

**DI, Dependency Injection**은 객체가 필요한 의존 객체를 직접 생성하지 않고, 외부에서 주입받는 방식.

즉, 클래스 내부에서 직접 `new` 키워드로 객체를 생성하는 것이 아니라, 스프링 컨테이너가 필요한 객체를 대신 넣어주는 구조.

---

## 5. DI를 사용하는 핵심 이유

* 객체 간의 결합도 낮춤.
* 재사용성 향상.
* 테스트 용이성 높임.

---

## 6. `@Autowired` 어노테이션

`@Autowired`는 스프링 컨테이너에 등록된 객체, 즉 **스프링 빈 Bean**을 다른 객체에서 사용할 수 있도록 자동으로 주입받게 해주는 어노테이션.

### 역할

* 필요한 객체를 스프링 컨테이너에서 찾아 자동으로 주입함.
* 개발자가 직접 객체를 생성하지 않아도 됨.
* 의존성 주입을 간단하게 처리할 수 있음.

## 7. DI 의존성 주입의 3가지 방법

1. 세터 주입 방식
2. 필드 주입 방식
3. 생성자 주입 방식

---

## 8. 세터 주입 방식

### 특징

setter 메서드 위에 `@Autowired`를 붙여 의존성을 주입하는 방식.

```java
private ProductRepository productRepository;

@Autowired
public void setProductRepository(ProductRepository productRepository) {
    this.productRepository = productRepository;
}
```

### 단점

세터 메서드는 보통 `public`으로 열려 있음.

따라서 객체가 생성된 이후에도 외부에서 의존성을 변경할 수 있음. 안정성이 떨어짐.


## 9. 필드 주입 방식 

### 특징

필드 주입 방식은 변수 선언부 바로 위에 `@Autowired`를 붙이는 방식.

```java
@Autowired
private ProductRepository productRepository;
```

### 단점

필드 주입은 의존성이 클래스 내부에 숨겨져 있음.

따라서 스프링 프레임워크 없이는 외부에서 의존성을 직접 주입하기 어려움.


## 10. 생성자 주입 방식 

### 특징

생성자 주입 방식은 클래스의 생성자를 통해 의존성을 주입받는 방식.

스프링에서 가장 권장하는 DI 방식.

```java
@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
}
```


