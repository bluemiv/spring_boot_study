package com.example.study.controller;

import com.example.study.model.SearchVo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class PostController {

  @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
  public String postMethod() {
    return "Hello Spring";
  }

  @PostMapping("/postMethod2")
  public String postMethod2() {
    return "Hello Spring";
  }

  // json, xml, multipart-form text-plain 등등...
  @PostMapping(value = "/search")
  public SearchVo search(@RequestBody SearchVo searchVo) {
    return searchVo;
  }
}
