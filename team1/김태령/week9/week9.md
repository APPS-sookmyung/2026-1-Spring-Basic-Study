#Spring-Basic-Week9

## 1. DDD

DDD는 **Domain Driven Development**의 약자.

소프트웨어 개발 관점에서 **도메인**은 사용자의 요구사항을 기준으로 기능을 묶은 영역을 의미.

예를 들어 쇼핑몰 서비스에서는 다음과 같이 도메인을 나눌 수 있음.

```text
쇼핑몰
├─ 회원 서비스
│  ├─ 회원 가입
│  ├─ 로그인
│  └─ 마이 페이지
│
└─ 상품 서비스
   ├─ 상품 조회
   ├─ 상품 등록
   └─ 상품 삭제
```

즉, 관련 있는 기능들을 하나의 도메인으로 묶어 관리하는 방식.

## 2. 도메인별 패키지 구조

상품 도메인의 경우 다음과 같은 구조로 구성할 수 있음.

```text
product
├─ ProductController
├─ ProductService
└─ ProductRepository
```

- `ProductController`: 사용자의 요청을 처음 받아 처리 로직을 Service 계층으로 위임하는 역할
- `ProductService`: 상품과 관련된 주요 처리 로직을 담당하는 역할
- `ProductRepository`: 상품 데이터를 저장하거나 조회하는 역할

## 3. 임시 데이터 저장

데이터베이스를 연결하지 않고 제품 데이터를 임시로 저장하고 관리하기 위해 사용할 수 있는 Java 컬렉션 타입은 **Map**.

`Map`은 key-value 형태로 데이터를 저장하는 자료구조.

예를 들어 상품 ID를 key로 사용하고, 상품 정보를 value로 저장할 수 있음.

```java
Map<Integer, String> db = new HashMap<>();
```

## 4. REST API와 HTTP 메서드

REST API에서는 리소스에 대해 어떤 작업을 할지 HTTP 메서드로 표현.

새로운 리소스를 생성하거나 등록하는 작업에는 주로 **POST** 메서드를 사용.


## 5. REST API URL 설계 규칙

REST API URL을 설계할 때 URL에는 동작이 아니라 **리소스의 종류**를 나타내는 것이 중요.

예를 들어 상품을 다루는 API라면 URL 경로는 `/product`와 같이 작성한다.

```text
http://localhost:8080/product
```

여기서 `http://localhost:8080`은 서버 주소이고, `/product`는 다루는 리소스가 상품이라는 것을 나타냄.

조회와 등록은 URL이 아니라 HTTP 메서드로 구분할 수 있음.


## 6. 상품 조회와 상품 등록 API

상품 조회는 **GET** 메서드를 사용.

```text
GET http://localhost:8080/product
```

상품 등록은 **POST** 메서드를 사용.

```text
POST http://localhost:8080/product
```

상품 조회와 상품 등록은 같은 URL을 사용하지만, HTTP 메서드가 다르기 때문에 서로 다른 기능으로 구분됨.