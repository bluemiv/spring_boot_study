package com.example.study.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor // 모든 매개변수를 가지는 생성자 생성
@NoArgsConstructor
@Entity
@Builder
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String account;

  private String email;

  private String phoneNumber;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Column(nullable = false)
  private String createdBy;

  private LocalDateTime updatedAt;

  private String updatedBy;
}
