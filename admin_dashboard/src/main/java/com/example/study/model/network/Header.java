package com.example.study.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Header<T> {

  // API 통신 시간
  //  @JsonProperty("transaction_time")
  private String transactionTime;

  // API 응답 코드
  private String resultCode;

  // API 설명
  private String description;

  // 제너릭 데이터
  private T data;

  // OKAY
  public static <T> Header<T> OK() {
    return (Header<T>)
        Header.builder()
            .transactionTime(LocalDateTime.now().toString())
            .resultCode("OK")
            .description("OK")
            .build();
  }

  // OKAY with Data
  public static <T> Header<T> OK(T data) {
    return (Header<T>)
        Header.builder()
            .transactionTime(LocalDateTime.now().toString())
            .resultCode("OK")
            .description("OK")
            .data(data)
            .build();
  }

  // ERROR
  public static <T> Header<T> ERROR(String description) {
    return (Header<T>)
        Header.builder()
            .transactionTime(LocalDateTime.now().toString())
            .resultCode("ERROR")
            .description(description)
            .build();
  }
}
