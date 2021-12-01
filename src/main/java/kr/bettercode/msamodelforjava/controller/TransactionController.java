package kr.bettercode.msamodelforjava.controller;

import kr.bettercode.msamodelforjava.dto.ChargeMeterResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/charge-points/{chargePointId}/transactions")
public class TransactionController {

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public void startCharging(@PathVariable Long chargePointId) {
    log.info("충전 시작: 충전소 id {}", chargePointId);
  }

  @PutMapping("/{transactionId}/meters")
  public ChargeMeterResponse getMeters(@PathVariable Long chargePointId, @PathVariable Long transactionId) {
    log.info("현재 충전량 확인: 충전소 id: {}, transaction id: {}", chargePointId, transactionId);

    ChargeMeterResponse chargeMeterResponse = new ChargeMeterResponse(100);
    log.info("충전량: {}", chargeMeterResponse);
    return chargeMeterResponse;
  }

  @PutMapping("/{transactionId}/stop")
  public void stopCharging(@PathVariable Long chargePointId, @PathVariable Long transactionId) {
    log.info("충전 중지: 충전소 id: {}, transaction id: {}", chargePointId, transactionId);
  }
}
