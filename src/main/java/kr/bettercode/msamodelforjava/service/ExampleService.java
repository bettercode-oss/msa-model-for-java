package kr.bettercode.msamodelforjava.service;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import kr.bettercode.msamodelforjava.dto.example.ExampleCreateRequest;
import kr.bettercode.msamodelforjava.dto.example.ExampleUpdateRequest;
import kr.bettercode.msamodelforjava.model.Example;
import kr.bettercode.msamodelforjava.repository.ExampleRepository;
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
  public Long delete() {
    return 0L;
  }

  private <T> void validate(T type) {
    Set<ConstraintViolation<T>> constraintViolations = validator.validate(type);
    if (!constraintViolations.isEmpty()) {
      log.info("유효성 검사 결과: {}", constraintViolations);
      throw new ConstraintViolationException(constraintViolations);
    }
  }
}
