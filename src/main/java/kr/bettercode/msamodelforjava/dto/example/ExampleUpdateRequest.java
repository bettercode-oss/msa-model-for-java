package kr.bettercode.msamodelforjava.dto.example;

import kr.bettercode.msamodelforjava.model.Example;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class ExampleUpdateRequest {

  @Nullable
  private String name;

  @Nullable
  private Integer age;

  @Nullable
  private String email;

  public Example toModel() {
    return new Example(name, age, email);
  }
}
