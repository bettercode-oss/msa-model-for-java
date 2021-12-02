package kr.bettercode.msamodelforjava.example.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import kr.bettercode.msamodelforjava.example.model.Example;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class ExampleCreateRequest {

  @NotEmpty
  private String name;

  @Range(min = 0, max = 150)
  private Integer age;

  @Email
  private String email;

  public Example toModel() {
    return new Example(name, age, email);
  }
}
