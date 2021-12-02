package kr.bettercode.msamodelforjava.example.dto.request;

import javax.validation.constraints.Min;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class PageRequest {

  @Min(1)
  private Integer page = 1;

  @Range(min = 1, max = 20)
  private Integer size = 20;

  public Long getOffset() {
    return (long) (page - 1) * size;
  }
}
