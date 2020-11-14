package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Slf4j
public class ItemRepositoryTest extends StudyApplicationTests {

  @Autowired private ItemRepository itemRepository;

  @Test
  @Disabled
  public void create() {
    Item item = new Item();
    item.setName("노트북");
    item.setContent("삼성 노트북");
    item.setPrice(1000000);

    Item newItem = itemRepository.save(item);
    Assertions.assertNotNull(newItem);
  }

  @Test
  public void read() {
    Optional<Item> item = itemRepository.findById(1L);
    Assertions.assertTrue(item.isPresent());

    item.ifPresent(
        selectItem -> {
          Assertions.assertEquals(1L, selectItem.getId());
        });
  }
}
