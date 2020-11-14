package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

  @Autowired OrderDetailRepository orderDetailRepository;

  @Test
  @Disabled
  public void create() {
    OrderDetail orderDetail = new OrderDetail();
    //    orderDetail.setOrderGroupId(1L);
    //    orderDetail.setItemId(1L);
    orderDetail.setStatus("WAITING");
    orderDetail.setCreatedAt(LocalDateTime.now());
    orderDetail.setCreatedBy("AdminServer");
    orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
    orderDetail.setQuantity(1);
    orderDetail.setTotalPrice(BigDecimal.valueOf(900000));

    OrderDetail createdOrderDetail = orderDetailRepository.save(orderDetail);
    Assertions.assertNotNull(createdOrderDetail);
    Assertions.assertEquals(1L, createdOrderDetail.getId());
  }

  @Test
  void read() {
    Optional<OrderDetail> orderDetail = orderDetailRepository.findById(1L);
    Assertions.assertTrue(orderDetail.isPresent());
    Assertions.assertEquals(1L, orderDetail.get().getId());
  }
}
