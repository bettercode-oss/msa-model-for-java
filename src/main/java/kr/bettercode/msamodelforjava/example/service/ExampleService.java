package kr.bettercode.msamodelforjava.example.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import kr.bettercode.msamodelforjava.example.dto.request.ExampleCreateRequest;
import kr.bettercode.msamodelforjava.example.dto.request.ExampleUpdateRequest;
import kr.bettercode.msamodelforjava.example.dto.request.PageRequest;
import kr.bettercode.msamodelforjava.example.dto.response.ExampleResponse;
import kr.bettercode.msamodelforjava.example.dto.response.ExamplesResponse;
import kr.bettercode.msamodelforjava.example.dto.response.PagingInfoResponse;
import kr.bettercode.msamodelforjava.example.model.Example;
import kr.bettercode.msamodelforjava.example.repository.ExampleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ExampleService {

  private final ExampleRepository exampleRepository;
  private final Validator validator;

  public ExampleService(ExampleRepository exampleRepository, Validator validator) {
    this.exampleRepository = exampleRepository;
    this.validator = validator;
  }

  @Transactional
  public Long create(ExampleCreateRequest request) {
    Example example = request.toModel();
    log.debug("변환된 example 정보: {}", example);

    validate(example);
    Long id = exampleRepository.save(example);
    log.debug("저장된 example의 id: {}", id);
    return id;
  }

  @Transactional
  public Long update(@NotNull Long id, ExampleUpdateRequest request) {
    Example example = request.toModel();
    example.setId(id);
    log.debug("변환된 example 정보: {}", example);

    Long updatedId = exampleRepository.updateByIdSelective(example);
    Example updatedExample = exampleRepository.findById(updatedId);
    log.debug("업데이트 된 example 정보: {}", updatedExample);
    validate(updatedExample);

    log.debug("업데이트 된 example의 id: {}", updatedId);
    return updatedId;
  }

  @Transactional
  public void delete(@NotNull Long id) {
    exampleRepository.deleteById(id);
    log.debug("삭제된 example의 id: {}", id);
  }

  private <T> void validate(T type) {
    Set<ConstraintViolation<T>> constraintViolations = validator.validate(type);
    if (!constraintViolations.isEmpty()) {
      log.info("유효성 검사 결과: {}", constraintViolations);
      throw new ConstraintViolationException(constraintViolations);
    }
  }

  @Transactional(readOnly = true)
  public ExamplesResponse list(PageRequest pageRequest) {
    List<Example> examples = exampleRepository.list(pageRequest);
    log.debug("조회된 example 목록: {}", examples);

    List<ExampleResponse> exampleResponses = examples.stream()
        .map(ExampleResponse::new)
        .collect(Collectors.toList());
    log.debug("변환된 example 목록: {}", exampleResponses);

    PagingInfoResponse pagingInfo = exampleRepository.getPagingInfo(pageRequest);
    ExamplesResponse examplesResponse = new ExamplesResponse(exampleResponses, pagingInfo);
    log.debug("examplesResponse: {}", examplesResponse);
    return examplesResponse;
  }
}
