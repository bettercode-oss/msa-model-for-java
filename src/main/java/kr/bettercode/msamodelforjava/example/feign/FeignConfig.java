package kr.bettercode.msamodelforjava.example.feign;

import feign.RetryableException;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 참고: https://github.com/woowabros/feign-apply-experience-sample/tree/master/src/main/java/io/github/mayaul/config
@Slf4j
@Configuration
public class FeignConfig {

  @Bean
  public Retryer retryer() {
    // Default의 인자로 retry 설정을 해줄 수 있습니다.
    return new Retryer.Default();
  }

  @Bean
  public ErrorDecoder decoder() {
    return (methodKey, response) -> {
      log.info("{} 요청이 성공하지 못했습니다. status : {}, body : {}", methodKey, response.status(), response.body());

      if (response.status() >= 400 && response.status() < 500) {
        log.info("{} 에러", response.status());
        return new RetryableException(response.status(), response.reason(), response.request().httpMethod(), null,
            response.request());
      }
      return new Exception("서버가 불안정해요.");
    };
  }
}
