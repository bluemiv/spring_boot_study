package com.example.study.controller;

import com.example.study.model.SearchVo;
import org.springframework.web.bind.annotation.*;

@RestController // REST API Controller 라는 것을 프레임워크에 알려줌
@RequestMapping("api") // localhost:8080/api 형태로 매핑 됨
public class GetController {

  // GET Method 로 통신
  // 경로는 api/getMethod 와 매핑됨
  @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
  public String getRequest() {
    return "Hello Spring";
  }

  // GET Method 통신
  // 경로는 api/getParam과 매핑됨
  @GetMapping("/getParam")
  public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {
    System.out.println("id :" + id);
    System.out.println("password :" + pwd);
    return "ID: " + id + ", Password: " + pwd;
  }

  // GET Method 통신
  @GetMapping("/getMultiParam")
  public String getMultiParameter(SearchVo vo) { // Parameter가 여러개인 경우, VO 객체로 받을 수 도 있음.
    return vo.toString();
  }

  // GET Method 통신
  // return 값을 vo 객체로 해주면, Jackson 라이브러리가 알아서 JSON 형태로 변환하여 응답해준다.
  @GetMapping("/returnJson")
  public SearchVo returnJson(SearchVo vo) {
    return vo; // {"username":"tester","email":"tester@google.com","page":1}
  }
}
