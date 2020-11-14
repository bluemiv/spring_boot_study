package com.example.study.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "admin_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AdminUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String account;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String status;

  @Column(nullable = false)
  private String role;

  private LocalDateTime lastLoginAt;

  private LocalDateTime passwordUpdatedAt;

  private Integer loginFailCount;

  private LocalDateTime registeredAt;

  private LocalDateTime unregisteredAt;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Column(nullable = false)
  private String createdBy;

  private LocalDateTime updatedAt;

  private String updatedBy;
}
