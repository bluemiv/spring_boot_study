package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

class OrderGroupRepositoryTest extends StudyApplicationTests {

  @Autowired private OrderGroupRepository orderGroupRepository;

  @Test
  @Disabled
  void create() {
    OrderGroup orderGroup = new OrderGroup();
    orderGroup.setOrderType("ALL");
    orderGroup.setRevAddress("경기도 성남시 분당구");
    orderGroup.setRevName("홍길동");
    orderGroup.setStatus("COMPLETE");
    orderGroup.setPaymentType("CARD");
    orderGroup.setTotalPrice(BigDecimal.valueOf(900000));
    orderGroup.setTotalQuantity(1);
    orderGroup.setCreatedAt(LocalDateTime.now());
    orderGroup.setCreatedBy("AdminServer");
    orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
    orderGroup.setArrivalDate(LocalDateTime.now());
    // orderGroup.setUserId(1L);

    OrderGroup createdOrderGroup = orderGroupRepository.save(orderGroup);
    Assertions.assertNotNull(createdOrderGroup);
    Assertions.assertEquals(1L, createdOrderGroup.getId());
  }

  @Test
  void read() {
    Optional<OrderGroup> orderGroup = orderGroupRepository.findById(1L);
    Assertions.assertTrue(orderGroup.isPresent());
    Assertions.assertEquals(1L, orderGroup.get().getId());
  }
}
