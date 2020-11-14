package com.example.study.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString(exclude = {"orderGroupList"})
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String account;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String status;

  private String email;

  @Column(nullable = false)
  private String phoneNumber;

  private LocalDateTime registeredAt;

  private LocalDateTime unregisteredAt;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Column(nullable = false)
  private String createdBy;

  private LocalDateTime updatedAt;

  private String updatedBy;

  // User 1 : N OrderGroup
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private List<OrderGroup> orderGroupList;
}
