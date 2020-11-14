package com.example.study.model.network.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserApiResponse {

  private long id;

  private String account;

  private String password;

  private String status;

  private String email;

  private String phoneNumber;

  private LocalDateTime registeredAt;

  private LocalDateTime unregisteredAt;
}
