package kr.bettercode.msamodelforjava.example.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class ExamplesResponse {

  private List<ExampleResponse> examples;
  private PagingInfoResponse pagingInfo;

  public ExamplesResponse(List<ExampleResponse> examples, PagingInfoResponse pagingInfo) {
    this.examples = examples;
    this.pagingInfo = pagingInfo;
  }
}
