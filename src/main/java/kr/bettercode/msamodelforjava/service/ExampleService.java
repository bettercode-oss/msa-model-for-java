package kr.bettercode.msamodelforjava.service;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import kr.bettercode.msamodelforjava.dto.ExampleCreateRequest;
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
  public int create(ExampleCreateRequest request) {
    Example example = request.toModel();
    log.debug("변환된 example 정보: {}", example);

    validate(example);
    int id = exampleRepository.save(example);
    log.debug("저장된 example의 id: {}", id);
    return id;
  }

  @Transactional
  public int update() {
    return 0;
  }

  @Transactional
  public int delete() {
    return 0;
  }

  private <T> void validate(T type) {
    Set<ConstraintViolation<T>> constraintViolations = validator.validate(type);
    if (!constraintViolations.isEmpty()) {
      log.info("유효성 검사 결과: {}", constraintViolations);
      throw new ConstraintViolationException(constraintViolations);
    }
  }
}
