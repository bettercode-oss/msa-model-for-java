package kr.bettercode.msamodelforjava.dto;

import lombok.Data;

@Data
public class ChargeMeterResponse {

  private final int meter;

  public ChargeMeterResponse(int meter) {
    this.meter = meter;
  }
}
