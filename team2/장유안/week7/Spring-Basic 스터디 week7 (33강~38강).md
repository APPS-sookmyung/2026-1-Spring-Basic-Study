Spring-Basic 스터디 week7 (33강\~38강)

@Controller에 @Component가 포함된다.
(둘 다 쓸 필요  없음)

@RequestMapping( ) = ( )의 요청에 따라 호출

@RestController = @Controller + @ResponseBody (RestAPI 만들어준다)



HTTP
Request
---

* URL (주소)
* Method (요청의 목적 -  조회, 삽입, 수정, value라고 표기) 



1. 조회 : GET
2. 등록/생성/삽입 : POST
3. 수정 : PUT(전체 수정) / PATCH(부분 수정)
4. 삭제 : DELETE



###### Response

* Body : 데이터

