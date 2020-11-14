package com.example.study.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"orderDetailList", "partner"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item")
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String status;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String title;

  private String content;

  @Column(nullable = false)
  private Integer price;

  private String brandName;

  private LocalDateTime registeredAt;

  private LocalDateTime unregisteredAt;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Column(nullable = false)
  private String createdBy;

  private LocalDateTime updatedAt;

  private String updatedBy;

  // Item N : 1 Partner
  @ManyToOne
  @JoinColumn(name = "partner_id")
  private Partner partner;

  // Item 1 : N OrderDetail
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
  private List<OrderDetail> orderDetailList;
}
