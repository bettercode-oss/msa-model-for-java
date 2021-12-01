package kr.bettercode.msamodelforjava.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import kr.bettercode.msamodelforjava.model.Example;
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
