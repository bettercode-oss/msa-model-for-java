package kr.bettercode.msamodelforjava.example.dto.request;

import kr.bettercode.msamodelforjava.example.model.Example;
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
