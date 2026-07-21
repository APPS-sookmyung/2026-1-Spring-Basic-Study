## Body에 데이터를 받아오는 방법 : RequestBody
- JSON으로 데이터를 보내야 한다.
- ```@RequestBody``` : HTTP 요청 본문에 담긴 JSON 등 데이터 → 자바 객체로 자동 변환해 받음
- Spring : RequestBody에 JSON 형태 데이터가 날아오면, JSON과 유사한 형태의 자바 객체에 접근해서, 객체의 변수 이름을 보고 맵핑을 해준다.
```java
@RequestMapping(value="/products", method = RequestMethod.POST)
// String이 아닌, Product 객체로 받는다
public void saveProduct(@RequestBody Product product) {
    productService.saveProduct(product);
}
```

## JSON (JavaScript Object Notation)
- 웹에서 데이터 교환 표준으로 쓰이는 형식
- 중괄호로 감싸서 key-value 형태로 담아서 사용
```JS
var prouct = {
    name = "handcream",
    price: 15000,
    description: "촉촉해요"
}
```

## @Component
- 스프링에서 컴포넌트 단위의 가장 기본적인 어노테이션
- 다음 세개의 어노테이션의 기반이 된다
    - @Controller
    - @Service : @Component와 동일한 기능 (이름만 다르다)
    - @Repository : @Component + DB 기본 예외처리

## 강의 이후 추가 학습
- 전체 상품 조회
- IoC 방법 : @Configuration + @Beam
- DB 연결 (JPA)
- Entity cvs DTO
- AOP