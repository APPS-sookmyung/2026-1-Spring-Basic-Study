Spring-Basic 스터디 week11 (55강\~61강)



요청할 때 데이터도 같이 줄 수 있는 방법\*\*

1. 주소에 데이터를 받아오는 방법 "쿼리스트링"
* http:://localhost:8080/product**s**?name=\_\_\_\_
2. 주소에 데이터를 받아오는 방법 "Path Variable"
* http:://localhost:8080/product**s**/{id}
* int id를 설정해두고 id++로 하나씩 id숫자를 올리면서 입력 받기

3\. body에 데이터를 받아오는 방법 "RequestBody"

* JSON으로 값을 보내야함.



**Hey, JSON**

* 데이터 형태
* JavaScript Object Notation
* var product = {

&#x09;	name: "handcream",

&#x09;	price: 15000,

&#x09;	description: "촉촉해요"

&#x09;}

&#x09;product.name

&#x09;product.price



@Component의 진화

* @Controller
* @Service : @Component + 뭐 더 없음
* @Repository : @Component + DB 기본 예외 처리



