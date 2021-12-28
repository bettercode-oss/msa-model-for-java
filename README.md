# MSA Model For Java

## Docker를 이용한 실행방법

프로젝트 루트에서 다음 순서로 명령어를 입력합니다.

```shell
./mvnw spring-boot:build-image
```

빌드가 되면

```shell
docker-compose up -d
```

## 기술 스택

- Java 8
- Spring Boot 2.5
  - Spring MVC
  - Spring Cloud Open Feign
- Maven
- MySQL 5.7
- MyBatis 3.5
- Slf4j
- Lombok

## 예제 프로젝트 1

[해당 패키지](./src/main/java/kr/bettercode/msamodelforjava/example) 참고

Example 이라는 간단한 모델을 가지고, 간단한 예제를 작성합니다.

### 기능 설명

- Read
  - Bean Validation
  - 페이징(페이징만 적용됨)
  - 조회 조건(페이징과 조회조건이 같이 적용됨)
- Create
  - Bean Validation
- Update
- Delete

### 패키지 설명

- controller: 컨트롤러가 위치하는 패키지입니다. 예제에서는 CUD와 R을 분리해서 컨트롤러를 작성했습니다.  
  `LoggingExampleController`의 경우에는 [하단](#Logging-샘플)을 참고해주세요.
- dto: DTO가 위치하는 패키지입니다. 해당 패키지에도 DTO를 두셔도 됩니다.
  - request: DTO 중 request에 해당하는 DTO가 위치하는 패키지입니다.
  - response: DTO 중 response에 해당하는 DTO가 위치하는 패키지입니다.
- model: DB의 Column과 매칭시켜둔 Model이 위치하는 패키지입니다.
- repository: DAO 역할을 하는 Repository가 위치하는 패키지입니다.
- service: Service가 위치하는 패키지입니다. 비즈니스 로직이 위치하면 됩니다.
- mapper: MyBatis Mapper는 classpath에서 조회되도록, resources/mapper에 위치하고 있습니다.

### 상세 기능 설명

- example 생성(`POST` http://localhost:8080/api/examples)
  - 요청 정보
    - ```json
      {
        "name":"hello",
        "age":"20",
        "email":"world@gmail.com"
      }
      ```
    - Bean Validation이 적용되어 있습니다.
      - `name`: Not Empty
      - `age`: 0 ~ 150
      - `email`: Email
  - 응답 정보
    - `201 CREATED`
    - ```json
      {
        "id": 1
      }
      ```
    - 생성된 id를 응답합니다.
  - 예외 정보
    - Bean Validation 실패시 400 응답이 발생합니다.
- example 수정(`PUT` http://localhost:8080/api/examples/{id})
  - 요청 정보
    - ```json
      {
        "name": "bettercode",
        "age": null,
        "email": null
      }
      ```
    - 모든 값은 Nullable 합니다.
  - 응답 정보
    - `200 OK`
    - ```json
        {
          "id": 1
        }
        ```
    - 수정된 id를 응답합니다.
- example 삭제(`DELETE` http://localhost:8080/api/examples/{id})
  - `204 NO CONTENT`
  - 응답 body가 없습니다.
- example 목록 페이징(`GET` http://localhost:8080/api/examples?page=1&size=20)
  - request parameter
    - `page`: 조회하고자 하는 page의 숫자를 입력합니다. (기본값: `1`, 최솟값: `1`, 필수 X)
    - `size`: 페이지에 표시될 content의 개수를 입력합니다. (기본값: `20`, 범위: `1` ~ `20`, 필수 X)
  - 응답 정보
    - `200 OK`
    - ```json
      {
        "examples": [
          {
            "age": 10,
            "email": "abcd@gmail.com",
            "id": 2,
            "name": "hello"
          }
        ],
        "pagingInfo": {
          "currentPage": 1,
          "pageSize": 20,
          "totalCount": 1,
          "totalPage": 1
        }
      }
      ```
      - 응답 객체 설명
        - `examples`: Example의 목록, `data`로 변경해서 공통화 해서 사용해도 됩니다.
        - `pagingInfo`: 페이지와 관련된 정보
          - `currentPage`: 현재 페이지 번호
          - `pageSize`: 페이지 크기
          - `totalCount`: 전체 데이터 개수
          - `totalPage`: 전체 페이지 수
- example 목록 검색 및 페이징(`GET` http://localhost:8080/api/examples?page=1&size=20&name=abc&minAge=0&maxAge=20&email=abcd)
  - request parameter
    - 검색조건
      - `name`: 검색어를 포함하는 이름을 찾기위한 조건입니다.
      - `minAge`: 최소 나이를 설정하기 위한 조건입니다.
      - `maxAge`: 최대 나이를 설정하기 위한 조건입니다.
      - `email`: 검색어를 포함하는 이메일을 찾기위한 조건입니다.
    - 검색조건은 nullable합니다.
  - 응답 정보는 상동합니다.

## 예제 프로젝트 2

좀 더 실무와 유사한 구조입니다.

주된 내용은 모델 정의 및 collection을 MyBatis에서 다루는 방법입니다.

비즈니스 로직의 구현은 되어있지 않으며, 동작이 이렇게 이루어질 것임을 추측하기 위한 설계가 되어있습니다.

### 상세 기능 설명

- 충전소의 transaction 목록 조회(`GET` http://localhost:8080/api/charge-points/1)
  - 해당 기능은 실제 쿼리를 전송하며, MyBatis에서 collection을 다루는 방법을 보여줍니다.
  - 1~6 번까지 mock data가 있습니다.
  - 중첩된 Collection은 N + 1 문제가 발생하므로 주의합니다. (chargePoint -> Transaction -(N+1 발생!!)> TransaciontEvents)
- 충전 시작(`POST` http://localhost:8080/api/charge-points/1/transactions)
  - 해당 기능은 Mock API 입니다.
  - 충전 시작 요청시 `202 ACCEPTED` 응답을 줍니다.
- 충전량 입력(`PUT` http://localhost:8080/api/charge-points/1/transactions/1/meters)
  - 해당 기능은 Mock API 입니다.
  - 충전량 입력시 `200 OK` 응답과 충전 정보를 줍니다.
  - 요청 정보
    - ```json
      {
        "chargeMeter": 100
      }
      ```
- 충전 종료(`PUT` http://localhost:8080/api/charge-points/1/transactions/1/stop)
  - 해당 기능은 Mock API 입니다.
  - 충전 종료 요청시 `202 ACCEPTED` 응답을 줍니다.

## Logging 샘플

[해당 파일](./src/main/java/kr/bettercode/msamodelforjava/example/controller/LoggingExampleController.java) 참고

로깅 예제 입니다.

## Feign Client 샘플

외부 API 요청을 테스트 하기 위한 샘플입니다.

`Retryer`와 `ErrorDecoder`를 Custom하여 사용합니다.

설정은 `application.properties`에 정의해두었습니다.

- `GET http://localhost:8080/posts`: 정상적으로 데이터를 불러올 경우의 예제입니다.
- `GET http://localhost:8080/posts/404error`: 404 오류가 발생하는 예제입니다.

`FeignClient` interface를 정의해 사용하는 형태입니다.

자세한 내용은 하단 참고자료를 확인해주세요.

### 참고자료

- [공식문서](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)
- [우아한 형제들 Feign Client](https://techblog.woowahan.com/2630/)
- [우아한 형제들 Feign Client2](https://techblog.woowahan.com/2657/)
- [Baeldung 가이드](https://www.baeldung.com/spring-cloud-openfeign)
- [Open Feign vs Feign Client](https://www.baeldung.com/netflix-feign-vs-openfeign)
