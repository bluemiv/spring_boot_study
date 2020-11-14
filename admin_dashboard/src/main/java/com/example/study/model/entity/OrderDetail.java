package com.example.study.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString(exclude = {"user", "item"})
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private LocalDateTime orderAt;

  // N:1 (OrderDetail:User)
  @ManyToOne
  @Column(nullable = false)
  private User user;

  // N:1 (OrderDetail:Item)
  @ManyToOne
  @Column(nullable = false)
  private Item item;
}
