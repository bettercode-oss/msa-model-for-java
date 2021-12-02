# MSA Model For Java

## 기술 스택

- Java 8
- Spring Boot 2.5
  - Spring MVC
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

## Logging 샘플

[해당 파일](./src/main/java/kr/bettercode/msamodelforjava/example/controller/LoggingExampleController.java) 참고

로깅 예제 입니다.
