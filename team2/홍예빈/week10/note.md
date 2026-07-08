# 10주차 학습 내용 정리
## HTTP Method
### Request
    - URL
    - Method
    - Body : POST, PUT ...

## 요청할 때 데이터도 같이 줄 수 있는 방법
### 1. 쿼리스트링
    주소에 데이터를 받아오는 방법
    http://localhost:8080/products?name=____
### 2. PathVariable
    주소에 데이터를 받아오는 방법
    http://localhost:8080/products/{id}
    - PathVariable은 { } 사용
    - product -> products 로 변경