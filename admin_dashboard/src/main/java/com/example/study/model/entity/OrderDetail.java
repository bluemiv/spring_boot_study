package com.example.study.model.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "order_detail")
@Getter
@Setter
@ToString(exclude = {"orderGroup", "item"})
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String status;

  @Column(nullable = false)
  private LocalDateTime arrivalDate;

  private Integer quantity;

  private BigDecimal totalPrice;

  @CreatedDate
  @Column(nullable = false)
  private LocalDateTime createdAt;

  @CreatedBy
  @Column(nullable = false)
  private String createdBy;

  @LastModifiedDate private LocalDateTime updatedAt;

  @LastModifiedBy private String updatedBy;

  // OrderDetail N : 1 OrderGroup
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_group_id")
  private OrderGroup orderGroup;

  // OrderDetail N : 1 Item
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id")
  private Item item;
}
