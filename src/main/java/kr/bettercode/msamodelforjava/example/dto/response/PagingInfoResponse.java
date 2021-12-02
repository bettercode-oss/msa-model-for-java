package kr.bettercode.msamodelforjava.example.dto.response;

import lombok.Data;

@Data
public class PagingInfoResponse {

  private Long totalCount;
  private Integer pageSize;
  private Integer currentPage;
  private Integer totalPage;
}
