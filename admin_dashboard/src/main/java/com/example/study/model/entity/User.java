package com.example.study.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

  // LAZY: 지연 로딩 (1:N, N:N 많은 양의 데이터가 있는 경우에 사용하는 것이 좋음)
  // -> SELECT * FROM USER WHERE ID = ?
  // EAGER: 즉시 로딩 (1:1는, N:1 연관 관계에서 사용하는 것이 좋음)
  // -> ITEM_ID = ORDER_DETAIL.ITEM_ID
  // -> USER_ID = USER.USER_ID
  // -> WHERE ITEM.ID = ?

  // 1:N (User:OrderDetail)
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private List<OrderDetail> orderDetailList;
}
