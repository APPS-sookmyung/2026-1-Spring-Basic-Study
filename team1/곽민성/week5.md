## 클래스 구조(= 역할 부여)
### Spring MVC
- **V(View)**: 화면. 하지만 이제 Spring 에서 안 만듦. React가 함
- **C(Controller)**: View(사용자)와 Model의 중간 매개체 역할
- **M(Model)**: 데이터 연산(DB 소통), 로직 담당
->  두 역할을 상세 역할로 쪼개서 각각 Repository, Service 라고 함

### Controller 제작

---

## 어노테이션
> **Annotation(어노테이션)**: Annotation은 코드 자체의 기능보다는, 해당 코드에 대한 부가적인 정보를 컴파일러, 빌드 도구, 프레임워크 등이 활용할 수 있도록 제공하는 역할

즉, **어노테이션의 역할**: 아래 세 친구에세 알려주기
1. 컴파일러에게 Ex.@Override
2. 빌드도구에게 Ex.@Getter
3. 프레임워크에게 Ex.@아래 클래스를 스프링빈으로 관리해달라고 요청

![](https://velog.velcdn.com/images/cherry70/post/c52fea31-b979-4718-a2d9-0f5e263d7851/image.png)
