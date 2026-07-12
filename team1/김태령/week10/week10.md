#Spring-Basic-Week10

## 1. 요청할 때 데이터를 전달하는 방법

클라이언트는 서버에 요청을 보낼 때 여러 방법으로 데이터를 전달할 수 있음.

1. Query String
2. Path Variable

---

## 2. Query String

Query String은 URL 뒤에 `?`를 붙이고, `키=값` 형태로 데이터를 전달하는 방법.

### 형식

```text
주소?키=값
```

### 예시

```text
http://localhost:8080/products?name=handcream
```

서버에 `name` 값으로 `handcream`을 전달.

여러 개의 값을 전달할 때는 `&`로 연결.

```text
http://localhost:8080/products?name=keyboard&price=30000
```

전달되는 값은 다음과 같음.

```text
name = keyboard
price = 30000
```

> Query String은 주로 `GET` 요청에서 조회 조건을 전달할 때 사용.

---

## 3. Path Variable

Path Variable은 URL 경로의 일부에 값을 넣어 전달하는 방법.

### 형식

```text
http://localhost:8080/products/{id}
```

`{id}` 부분에는 실제 값이 들어감.

### 예시

```text
http://localhost:8080/products/1
```

여기에서 `1`은 상품의 ID.

서버는 이 요청을 **1번 상품에 대한 요청**으로 해석.

> Path Variable은 특정 데이터를 구분하는 ID처럼, 반드시 필요한 값을 전달할 때 주로 사용.

---

## 4. Postman에서 요청 보내기

Postman은 서버에 HTTP 요청을 직접 보내고 응답을 확인할 수 있는 도구.

### GET 요청

1. Method를 `GET`으로 선택.
2. URL을 입력.
3. `Send` 버튼을 누름.

```text
http://localhost:8080/products
```

### Query String 전달

URL에 직접 입력할 수 있음.

```text
http://localhost:8080/products?name=handcream
```

### Path Variable 전달

URL의 경로에 값을 직접 입력.

```text
http://localhost:8080/products/1
```

