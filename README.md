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

## Logging 샘플

[해당 파일](./src/main/java/kr/bettercode/msamodelforjava/example/controller/LoggingExampleController.java) 참고

로깅 예제 입니다.
