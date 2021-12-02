package kr.bettercode.msamodelforjava.example.controller;

import javax.validation.Valid;
import kr.bettercode.msamodelforjava.example.dto.request.ExampleSearchRequest;
import kr.bettercode.msamodelforjava.example.dto.request.PageRequest;
import kr.bettercode.msamodelforjava.example.dto.response.ExamplesResponse;
import kr.bettercode.msamodelforjava.example.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/examples")
public class ReadExampleController {

  private final ExampleService exampleService;

  public ReadExampleController(ExampleService exampleService) {
    this.exampleService = exampleService;
  }

  @GetMapping
  public ExamplesResponse listPaging(@Valid PageRequest pageRequest) {
    log.debug("example 목록 조회 | 페이징 조건: {}", pageRequest);
    return exampleService.list(pageRequest);
  }

  @GetMapping("/search")
  public ExamplesResponse search(@Valid PageRequest pageRequest, ExampleSearchRequest searchRequest) {
    log.debug("example 검색 | 페이징 조건: {}, 검색 조건: {}", pageRequest, searchRequest);
    return exampleService.search(pageRequest, searchRequest);
  }
}
