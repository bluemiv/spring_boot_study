package com.example.study.controller.api;

import com.example.study.interfaces.CrudInterface;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface {

  @PostMapping("")
  @Override
  public Header create() {
    return null;
  }

  @GetMapping("{id}")
  @Override
  public Header read(@PathVariable(name = "id") Long id) {
    return null;
  }

  @PutMapping("")
  @Override
  public Header update() {
    return null;
  }

  @DeleteMapping("{id}")
  @Override
  public Header delete(@PathVariable(name = "id") Long id) {
    return null;
  }
}
