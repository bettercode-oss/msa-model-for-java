package kr.bettercode.msamodelforjava.examplecontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 이 클래스는 로그를 남길 때 참고하기 위한 정보를 담고있습니다. 로깅 예제를 직접 실행해보고, 조작하면서 로그를 확인해보세요.
 */
@Slf4j
@RestController
@RequestMapping("/logging")
public class LoggingExampleController {

  @GetMapping("")
  public void logExample() {
    log.info("===========================================================================================");
    log.trace("trace는 매우 상세한 정보를 로깅합니다.");
    log.debug("debug는 디버깅에 도움이 될만한 정보를 로깅합니다. 개발환경에서만 출력되도록 둡니다.");
    log.info("info는 업무 로직을 수행하며 진행상황을 로깅합니다. 프로덕션 환경에서는 해당 로그레벨 이상으로 로깅되도록 합니다.");
    log.warn("warn은 잠재적으로 문제가 될 수 있을만한 부분에 로깅합니다.");
    log.error("error는 에러가 발생했을 때 로깅합니다.");

    log.info("Exception과 함께 로그 메시지를 남길 수 있습니다.", new Exception("exception message"));
    log.info("{} 객체를 log로 출력할 수 있습니다. {}", "이렇게", new String[]{"객체나", "배열, 컬렉션도", "사용할 수 있습니다."});
    log.info("===========================================================================================");
    log.info("log level은 application.properties 파일에서 변경할 수 있습니다.");
    log.info("logging.level.kr.bettercode.msamodelforjava=TRACE 로 변경하고 실행해보세요.");
    log.info("http://localhost:8080/logging 에 접속하여, 로그를 확인하세요.");
    log.trace("이 로그가 보인다면 잘 설정하신 겁니다.");
    log.info("===========================================================================================");
    log.info("logging.level.kr.bettercode.msamodelforjava=INFO 로 변경하고 실행해보세요.");
    log.info("http://localhost:8080/logging 에 접속하여, 로그를 확인하세요.");
    log.debug("이 로그가 보이지 않는다면 잘 설정하신 겁니다.");
    log.info("===========================================================================================");
  }
}
