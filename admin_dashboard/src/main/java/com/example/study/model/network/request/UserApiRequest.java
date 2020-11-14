package com.example.study.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserApiRequest {

  private long id;

  private String account;

  private String password;

  private String status;

  private String email;

  private String phoneNumber;
}
