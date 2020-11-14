package com.example.study.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "partner")
@Getter
@Setter
@ToString(exclude = {"itemList", "category"})
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Partner {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String status;

  private String address;

  private String callCenter;

  private String partnerNumber;

  private String businessNumber;

  private String ceoName;

  private LocalDateTime registeredAt;

  private LocalDateTime unregisteredAt;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Column(nullable = false)
  private String createdBy;

  private LocalDateTime updatedAt;

  private String updatedBy;

  // Partner 1 : N Item
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
  private List<Item> itemList;

  // Partner N : 1 Category
  @ManyToOne(fetch = FetchType.LAZY)
  private Category category;
}
