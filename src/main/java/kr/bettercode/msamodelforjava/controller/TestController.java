package kr.bettercode.msamodelforjava.controller;

import java.util.List;
import kr.bettercode.msamodelforjava.dto.ChargePointDto;
import kr.bettercode.msamodelforjava.repository.ChargePointRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  private final ChargePointRepository chargePointRepository;

  public TestController(ChargePointRepository chargePointRepository) {
    this.chargePointRepository = chargePointRepository;
  }

  @GetMapping("/")
  public List<ChargePointDto> chargePointDto() {
    return chargePointRepository.selectAll();
  }
}
