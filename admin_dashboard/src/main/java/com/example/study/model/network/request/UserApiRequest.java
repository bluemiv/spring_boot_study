package com.example.study.model.network.request;

import lombok.*;

@Getter
@Builder
@ToString
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
