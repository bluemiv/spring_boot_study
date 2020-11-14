package com.example.study.model.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "partner")
@Getter
@Setter
@Builder
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

  @CreatedDate
  @Column(nullable = false)
  private LocalDateTime createdAt;

  @CreatedBy
  @Column(nullable = false)
  private String createdBy;

  @LastModifiedDate private LocalDateTime updatedAt;

  @LastModifiedBy private String updatedBy;

  // Partner 1 : N Item
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
  private List<Item> itemList;

  // Partner N : 1 Category
  @ManyToOne(fetch = FetchType.LAZY)
  private Category category;
}
