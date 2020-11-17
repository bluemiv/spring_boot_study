package com.example.study.model.network.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemApiResponse {
  private Long id;

  private String status;

  private String name;

  private String title;

  private String content;

  private BigDecimal price;

  private String brandName;

  private LocalDateTime registeredAt;

  private LocalDateTime unregisteredAt;

  private Long partnerId;
}
