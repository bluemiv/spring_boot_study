package com.example.study.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order_group")
@Getter
@Setter
@ToString(exclude = {"user", "orderDetailList"})
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String status;

  // 일괄 주문 / 개별 주문
  @Column(nullable = false)
  private String orderType;

  private String revAddress;

  private String revName;

  // 현금 / 카
  private String paymentType;

  private BigDecimal totalPrice;

  private Integer totalQuantity;

  private LocalDateTime orderAt;

  private LocalDateTime arrivalDate;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Column(nullable = false)
  private String createdBy;

  private LocalDateTime updatedAt;

  private String updatedBy;

  // OrderGroup 1 : N User
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  // OrderGroup 1 : N OrderDetail
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
  private List<OrderDetail> orderDetailList;
}
