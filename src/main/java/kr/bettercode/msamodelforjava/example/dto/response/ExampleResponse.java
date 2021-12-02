package kr.bettercode.msamodelforjava.example.dto.response;

import kr.bettercode.msamodelforjava.example.model.Example;
import lombok.Data;

@Data
public class ExampleResponse {

  private Long id;
  private String name;
  private Integer age;
  private String email;

  public ExampleResponse(Example example) {
    this.id = example.getId();
    this.name = example.getName();
    this.age = example.getAge();
    this.email = example.getEmail();
  }
}
