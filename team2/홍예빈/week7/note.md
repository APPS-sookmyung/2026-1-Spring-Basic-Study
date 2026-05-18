# 7주차 학습 내용 정리
## @RequestMapping과 핸들러 메소드
### @RequestMapping
    사용자가 요청하면 아래 메소드를 호출해줌
    소괄호를 통해 상세하게 작성 가능

## HTTP request
### Request
    알고 있어야 하는 것
    1. URL (주소)
    2. Method (목적) ex. 조회, 삽입, 수정
### Method 종류
    1. 조회 : GET
    2. 등록/생성/삽입 : POST
    3. 수정 : (전체) PUT / (부분) PATCH
    4. 삭제 : DELETE
### Response
    Body : 데이터를 담아 전달

## @RestController
### @RestController
    HTTP를 잘 지키는 Controller
    옛날 @Controller + 최신식 @ResponseBody
