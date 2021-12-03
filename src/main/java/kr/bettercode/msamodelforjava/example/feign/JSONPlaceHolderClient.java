package kr.bettercode.msamodelforjava.example.feign;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/")
public interface JSONPlaceHolderClient {

  @GetMapping("/posts")
  List<Object> getPosts();

  @GetMapping("/nonono")
  List<Object> getNotFoundError();
}
