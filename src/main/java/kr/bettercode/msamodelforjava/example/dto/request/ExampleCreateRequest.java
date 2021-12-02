package kr.bettercode.msamodelforjava.example.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import kr.bettercode.msamodelforjava.example.model.Example;
import lombok.Data;

@Data
public class ExampleCreateRequest {

  @NotEmpty
  private String name;

  @Positive
  private Integer age;

  @Email
  private String email;

  public Example toModel() {
    return new Example(name, age, email);
  }
}
