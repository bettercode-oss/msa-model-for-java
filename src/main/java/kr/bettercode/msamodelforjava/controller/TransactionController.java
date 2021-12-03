package kr.bettercode.msamodelforjava.controller;

import kr.bettercode.msamodelforjava.dto.ChargeMeterRequest;
import kr.bettercode.msamodelforjava.dto.ChargeMeterResponse;
import kr.bettercode.msamodelforjava.model.ChargePoint;
import kr.bettercode.msamodelforjava.repository.ChargePointRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/charge-points/{chargePointId}")
public class TransactionController {

  private final ChargePointRepository chargePointRepository;

  public TransactionController(ChargePointRepository chargePointRepository) {
    this.chargePointRepository = chargePointRepository;
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @PostMapping("/transactions")
  public void startCharging(@PathVariable Long chargePointId) {
    log.info("충전 시작: 충전소 id {}", chargePointId);
  }

  @PutMapping("/transactions/{transactionId}/meters")
  public ChargeMeterResponse getMeters(
      @PathVariable Long chargePointId,
      @PathVariable Long transactionId,
      @RequestBody ChargeMeterRequest chargeMeter) {
    log.info("충전량 입력: 충전소 id: {}, transaction id: {}, 충전량: {}", chargePointId, transactionId, chargeMeter);

    ChargeMeterResponse chargeMeterResponse = new ChargeMeterResponse(chargeMeter.getChargeMeter());
    log.info("충전량: {}", chargeMeterResponse);
    return chargeMeterResponse;
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @PutMapping("/transactions/{transactionId}/stop")
  public void stopCharging(@PathVariable Long chargePointId, @PathVariable Long transactionId) {
    log.info("충전 중지: 충전소 id: {}, transaction id: {}", chargePointId, transactionId);
  }

  @GetMapping
  public ChargePoint getChargePoint(@PathVariable Long chargePointId) {
    return chargePointRepository.selectChargePointById(chargePointId);
  }
}
