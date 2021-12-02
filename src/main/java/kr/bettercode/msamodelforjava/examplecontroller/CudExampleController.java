package kr.bettercode.msamodelforjava.examplecontroller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import kr.bettercode.msamodelforjava.dto.example.ExampleCreateRequest;
import kr.bettercode.msamodelforjava.dto.example.ExampleUpdateRequest;
import kr.bettercode.msamodelforjava.dto.example.IdResponse;
import kr.bettercode.msamodelforjava.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public IdResponse create(@RequestBody @Valid ExampleCreateRequest request) {
    log.debug("example 생성 요청 정보: {}", request);

    Long id = exampleService.create(request);
    log.debug("생성된 example의 id: {}", id);
    return new IdResponse(id);
  }

  @PutMapping("/{id}")
  public IdResponse update(
      @PathVariable @NotNull Long id,
      @RequestBody ExampleUpdateRequest request
  ) {
    log.debug("example 수정 요청 정보: {}", request);

    Long updatedId = exampleService.update(id, request);
    log.debug("수정된 example의 id: {}", updatedId);
    return new IdResponse(updatedId);
  }

  @DeleteMapping
  public IdResponse delete() {
    return new IdResponse(0L);
  }
}
