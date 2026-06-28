# 9주차 학습 내용 정리
## DDD
### Domain Driven Development
    Domain : 사용자가 원하는 요구사항 → 제공하는 기능의 덩어리
    ex. 쇼핑몰에서 회원가입, 로그인, 마이페이지 → 회원 서비스
    … 상품 조회, 상품 등록, 상품 삭제 → 상품 서비스

## DB가 없는데 어디 저장하지?
### Map 활용
    Map을 활용하여 데이터를 저장하고 꺼낼 수 있도록 함

## REST API URL 설계 규칙
### REST API URL 설계 규칙
    [http://localhost:8080](https://localhost:8080) : 기본
    상품 조회 (method=GET) : http://localhost:8080/product
    상품 등록 (method=POST) : http://localhost:8080/product
    규칙 : method를 제외하고 남은 부분을 URL로 나타냄