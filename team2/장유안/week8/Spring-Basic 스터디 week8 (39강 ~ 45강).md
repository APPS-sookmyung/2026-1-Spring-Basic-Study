### Spring-Basic 스터디 week8 (39강 \~ 45강)

##### 

##### **Spring MVC**

* //View : 화면
* Controller: View(사용자) - Model 중간 매개체
* Model: 데이터 연산, 로직/ 1. DB소통(repository) , 2. 로직 (service( 상세 역할 ))
* service- '데이터를 가지고' 연산/처리
* repository- 데이터 관리/ 소통



내가 새로운 객체를 만드는 것이 아니라 Spring이 새로운 객체를 만들어주는 것이 포인트!

ProductService productService = new ProductService();

대신에

ProductService productService; 쓰고 대신 @Component 실행하기 (필드에 객체 생성)

그리고 앞에 @Autowired쓰기

@Autowired- 스프링아 너 이거 있니?하고 찾는거 (DI까지! service까지 호출)



다음은 repository

ProductRepository만들어서 service와 같은 과정 거치기



##### **DI방법은 사실 3가지 (사실은 위치만 다르다)**

@Autowired

1. @Autowired // 세터 주입 방식
public void set\*\*\*(ProductRepository productRepository)
2. @Autowired // 필드 주입 방식
private ProductRepository productRepository;
3. **@Autowired // 생성자 주입 방식**

&#x20;    **ProductService(ProductRepository productRepository)**







