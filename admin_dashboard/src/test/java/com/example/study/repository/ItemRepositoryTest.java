package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

class ItemRepositoryTest extends StudyApplicationTests {

  @Autowired private ItemRepository itemRepository;

  @Test
  @Disabled
  void create() {
    String name = "삼성 노트북";
    String status = "UNREGISTERED";
    String title = "삼성 노트북 A100";
    String content = "2020년형 삼성 노트북";
    int price = 900000;
    String brandName = "SAMSUNG";
    LocalDateTime registeredAt = LocalDateTime.now();
    LocalDateTime createdAt = LocalDateTime.now();
    String createdBy = "Partner01";
    Long partnerId = 1L;

    Item item = new Item();
    item.setName(name);
    item.setStatus(status);
    item.setTitle(title);
    item.setContent(content);
    item.setPrice(price);
    item.setBrandName(brandName);
    item.setRegisteredAt(registeredAt);
    item.setCreatedAt(createdAt);
    item.setCreatedBy(createdBy);
    item.setPartnerId(partnerId);

    Item createdItem = itemRepository.save(item);
    Assertions.assertNotNull(createdItem);
    Assertions.assertEquals(name, createdItem.getName());
  }

  @Test
  void read() {
    Optional<Item> item = itemRepository.findById(1L);
    Assertions.assertTrue(item.isPresent());
    Assertions.assertEquals(1L, item.get().getId());
  }
}
