package com.example.study.controller.api;

import com.example.study.interfaces.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

  @Autowired private UserApiLogicService userApiLogicService;

  @PostMapping("")
  @Override
  public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
    log.info("{}", request.getData().toString());
    return userApiLogicService.create(request);
  }

  @GetMapping("{id}")
  @Override
  public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
    return null;
  }

  @PutMapping("")
  @Override
  public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
    return null;
  }

  @DeleteMapping("{id}")
  @Override
  public Header delete(@PathVariable(name = "id") Long id) {
    return null;
  }
}
