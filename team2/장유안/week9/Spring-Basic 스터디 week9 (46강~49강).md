Spring-Basic 스터디 week9 (46강\~49강)



**복습**

* public void
* public = 어디서든 호출 가능
* void = 아무것도 반환하지 않는다
* @RequestMapping = 클라이언트의 HTTP 요청 URL을 특정 메서드와 연결해주는 어노테이션





**DDD**

* Domain Driven Development
* 도메인 = 기능의 덩어리 ( 사용자가 원하는 요구사항 -> 제공하는 '기능의 덩어리' )
* ex) 쇼핑몰: 회원가입, 로그인, 마이페이지, 상품 조회, 등록, 삭제... (회원서비스와 상품 서비스로 나눌 수 있다.) ( \_\_서비스의 \_\_에 올 수 있으면 도메인 )
* product, member, user...
* product안에 ProductController, ProductService, ProductRepository



**DB**

* Map 사용
* ProductRepository의 필드에 만들기 -> 하위 필드에서 모두 사용하니까



REST API URL 설계규칙

* 메소드로 뺼 수 있는 건 뺴고 남은 것만 URL로 나타낸다.
* / : \~의, \~중에
* http://localhost:8080
* 상품조회 (method = GET)

  * http://localhost:8080/product
* 상품등록 (method = POST)

  * http://localhost:8080/product

