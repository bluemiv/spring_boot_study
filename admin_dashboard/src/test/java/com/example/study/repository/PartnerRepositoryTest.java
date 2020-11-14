package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Partner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

class PartnerRepositoryTest extends StudyApplicationTests {

  @Autowired private PartnerRepository partnerRepository;

  @Test
  @Disabled
  void create() {
    String name = "Test01";
    String status = "REGISTERED";
    String address = "경기도 분당구 삼평동";
    String callCenter = "031-1234-5678";
    String partnerNumber = "010-3245-0976";
    String businessNumber = "010-5667-4575";
    LocalDateTime registeredAt = LocalDateTime.now();
    LocalDateTime createdAt = LocalDateTime.now();
    String createdBy = "AdminServer";

    Partner partner = new Partner();
    partner.setName(name);
    partner.setStatus(status);
    partner.setAddress(address);
    partner.setCallCenter(callCenter);
    partner.setPartnerNumber(partnerNumber);
    partner.setBusinessNumber(businessNumber);
    partner.setRegisteredAt(registeredAt);
    partner.setCreatedAt(createdAt);
    partner.setCreatedBy(createdBy);
    //    partner.setCategoryId(1L);

    Partner createdPartner = partnerRepository.save(partner);
    Assertions.assertNotNull(createdPartner);
    Assertions.assertEquals(name, createdPartner.getName());
    Assertions.assertEquals(callCenter, createdPartner.getCallCenter());
  }

  @Test
  void read() {
    String name = "Test01";
    Optional<Partner> partner = partnerRepository.findById(1L);
    Assertions.assertTrue(partner.isPresent());
    Assertions.assertEquals(name, partner.get().getName());
  }
}
