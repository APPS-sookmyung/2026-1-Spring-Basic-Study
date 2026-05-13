## [섹션 7: 24~28강]
- 상품 조회/등록 API 프로젝트

- Dependencies – Spring Web   
Build web, including RESTful (REST API 제공), applications using Spring MVC (Spring MVC를 활용해서 애플리케이션을 만든다). Uses Apache Tomcat as the default embedded container.

### Spring MVC
1. **Model** : 데이터 연산을 수행하는 Repository + 로직을 만드는 Service
2. **View** : 화면 (만들 수는 있지만, 프론트엔드가 담당하는 부분)
3. **Controller** : View(사용자) - Model 의 중간 매개체
- 클래스 구조 = 역할 부여
- View ↔ Controller ↔ Model
- View가 요청을 했을 때 Controller가 해당 요청을 가장 먼저 받는 역할이기 때문에, Controller 부터 만들어보도록 하자

```java
package com.example.demo;

// 상품 조회, 상품 등록 담당 Controller
public class ProductController {
    // 클래스 이름은 구체적으로 작성. 안 좋은 예 : Controller
}
```


### 어노테이션 (Annotation) : 알려주기
- Annotation은 그 자체로 로직을 가지는 것이 아니라, 코드에 대한 정보를 컴파일러, 빌드도구, 프레임워크 등이 활용할 수 있도록 제공하는 역할을 한다.
1. **컴파일러에게** e.g. @Override
    ```java
    public class AnnotationDemo {
    }

    class Parent {
        public void method() {
            System.out.println("parent");
        }
    }

    class Child extends Parent{
        @Override
        public void method() {
            System.out.println("child");
        }
    }
    ```

    - 이때 ```public void metod``` 라고 오타를 내는 경우, 다음과 같은 내용의 컴파일 오류 발생   
        > * The method does override or implement a method declared in a supertype.   
        > * The method has a signature that is override-equivalent to that of any public method declared in Object.
    
    <br>
    
    - ```@Override``` 를 적지 않으면, metod라고 오타를 내도 단순히 '새 메서드'로 인식되어 오류가 발생하지 않는다. 컴파일러에에게 method가 Parent의 메서드 method를 Overriding 한다고 명시해주지 않은 것이기 때문이다.

2. **빌드도구에게** e.g. @Getter
3. **프레임워크에게** e.g. @ : 다음 클래스를 스프링 빈으로 관리해달라고 알림