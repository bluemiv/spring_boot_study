package com.example.study.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@ToString(exclude = {"partnerList"})
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String type;

  private String title;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Column(nullable = false)
  private String createdBy;

  private LocalDateTime updatedAt;

  private String updatedBy;

  // Category 1 : N Partner
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  private List<Partner> partnerList;
}
