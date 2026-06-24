# 8주차 학습 내용 정리
## 모델을 이렇게 쪼갤 수도 있습니다
### Model
    Service : 데이터를 가지고 연산/처리
    Repository : 데이터 관리/소통
    -> Controller는 Service에게 요청

## 문제점을 찾으셨나요?
### 문제점 
    1. getProduct() 호출할 때마다 새로운 Service 객체가 생성됨
    2. getProduct() 밖에선 Service 사용X

## @Autowired 스프링님, 객체 좀 주세요
### @Autowired
    이렇게 생긴 객체를 관리하고 있다면 주세요
    -> DI를 스프링에 요청

## DI 방법은 사실 3가지
### DI 방법
    1. 세터 주입 방식 : @Autowired public void set***
    2. 필드 주입 방식 : @Autowired private ProductRepository productRepository
    3. 생성자 주입 방식 : @Autowired ProductService
    -> 요즘은 생성자 주입 방식을 선호 