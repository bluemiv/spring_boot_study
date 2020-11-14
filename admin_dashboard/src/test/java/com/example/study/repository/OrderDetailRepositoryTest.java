package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

  @Autowired OrderDetailRepository orderDetailRepository;

  @Test
  @Disabled
  public void create() {
    OrderDetail orderDetail = new OrderDetail();
  }
}
