package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Getter, Setter 를 생성해줌
@AllArgsConstructor // 모든 매개변수를 가지는 생성자가 만들어짐
public class SearchVo {

  private String username;
  private String email;
  private int page;
}
