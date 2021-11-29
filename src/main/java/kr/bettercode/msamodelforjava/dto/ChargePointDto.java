package kr.bettercode.msamodelforjava.dto;

import lombok.Data;

@Data
public class ChargePointDto {

  private Long id;
  private String vendor;
  private String model;
  private String status;
}
