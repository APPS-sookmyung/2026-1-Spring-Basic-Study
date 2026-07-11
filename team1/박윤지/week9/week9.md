## DDD (Domain Driven Development : 도메인 기반 개발)
- 소프트웨어 개발에서의 **도메인**
    - 사용자의 요구사항을 중심으로 묶은 기능 단위
- ex. 쇼핑몰
    - 회원 가입, 로그인, 마이페이지... => **회원** 서비스 (회원 도메인)
    - 상품 조회, 상품 등록, 상품 삭제... => **상품** 서비스  (상품 도메인)

- 도메인을 기준으로 패키지 이름을 만든다
    - product   
    ㄴ ProductController   
    ㄴ ProductService   
    ㄴ ProductRepository

## DB 없이 가볍게 저장 -> 자바 컬렉션 사용
- key-value 형태로 저장 : **Map**
    - id : 1, 2, 3....
    - value : Notebook,...

## REST API URL 설계 규칙
- 메서드로 나타낼 수 있는 부분은 빼고, 그 외의 남은 것들(즉, 서버에서 다루는 리소스의 종류)을 모두 URL로 나타내야한다.
    - **" / "** : ~의, ~중에 라는 의미
- ex. 상품 조회, 상품 등록
    - 조회와 등록은 각각 GET과 POST라는 메서드로 나타낼 수 있으므로, 상품이라는 것까지만 URL로 나타낸다.
    - 기본 : http://localhost:8080
    - 상품 조회 (method=GET) : http://localhost:8080/product
    - 상품 등록 (method=POST) : http://localhost:8080/product