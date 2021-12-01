package kr.bettercode.msamodelforjava.examplecontroller;

import javax.validation.Valid;
import kr.bettercode.msamodelforjava.dto.ExampleCreateRequest;
import kr.bettercode.msamodelforjava.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/example")
public class CudExampleController {

  private final ExampleService exampleService;

  public CudExampleController(ExampleService exampleService) {
    this.exampleService = exampleService;
  }

  @PostMapping
  public int create(@RequestBody @Valid ExampleCreateRequest request) {
    log.debug("example 생성 요청 정보: {}", request);

    int id = exampleService.create(request);
    log.debug("생성된 example의 id: {}", id);
    return id;
  }

  @PutMapping
  public int update() {
    return 0;
  }

  @DeleteMapping
  public int delete() {
    return 0;
  }
}
