package com.example.study.controller.api;

import com.example.study.interfaces.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

  @PostMapping("")
  @Override
  public Header<UserApiResponse> create(@RequestBody UserApiRequest userApiRequest) {
    return null;
  }

  @GetMapping("{id}")
  @Override
  public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
    return null;
  }

  @PutMapping("")
  @Override
  public Header<UserApiResponse> update(@RequestBody UserApiRequest userApiRequest) {
    return null;
  }

  @DeleteMapping("{id}")
  @Override
  public Header delete(@PathVariable(name = "id") Long id) {
    return null;
  }
}
