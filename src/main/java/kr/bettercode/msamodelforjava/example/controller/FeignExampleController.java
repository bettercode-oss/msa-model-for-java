package kr.bettercode.msamodelforjava.example.controller;

import java.util.List;
import kr.bettercode.msamodelforjava.example.feign.JSONPlaceHolderClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/posts")
public class FeignExampleController {

  private final JSONPlaceHolderClient jsonPlaceHolderClient;

  public FeignExampleController(JSONPlaceHolderClient jsonPlaceHolderClient) {
    this.jsonPlaceHolderClient = jsonPlaceHolderClient;
  }

  @GetMapping
  public List<Object> getPosts() {
    return jsonPlaceHolderClient.getPosts();
  }

  @GetMapping("/404error")
  public List<Object> getNotFoundError() {
    return jsonPlaceHolderClient.getNotFoundError();
  }
}
