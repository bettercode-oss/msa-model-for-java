package kr.bettercode.msamodelforjava.example.dto.request;

import lombok.Data;

@Data
public class ExampleSearchRequest {

  private String name;
  private Integer minAge;
  private Integer maxAge;
  private String email;
}
