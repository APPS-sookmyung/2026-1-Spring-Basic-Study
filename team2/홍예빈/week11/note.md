# 11주차 학습 내용 정리
## 요청할 때 데이터도 같이 줄 수 있는 방법
### 1. 쿼리스트링
    주소에 데이터를 받아오는 방법
    http://localhost:8080/products?name=____
### 2. PathVariable
    주소에 데이터를 받아오는 방법
    http://localhost:8080/products/{id}
    - PathVariable은 { } 사용
    - product -> products 로 변경
### 3. RequestBody 
    body에 데이터를 받아오는 방법
    JSON으로 값을 보내야 함

## hey, Jason 아니고 Json
### JSON
    JSON(JavaScript Object Notation) : 데이터 형태
    product.name, product.price 형식으로 데이터 불러옴

## @Component 진화
### @Service
    @Service = @Component + ;;;
### @Repository
    @Repository = @Component + DB 기본 예외 처리

## 완강