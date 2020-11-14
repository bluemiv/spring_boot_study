package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

class CategoryRepositoryTest extends StudyApplicationTests {

  @Autowired private CategoryRepository categoryRepository;

  @Test
  @Disabled
  void create() {
    String type = "COMPUTER";
    String title = "컴퓨터";
    LocalDateTime localDateTime = LocalDateTime.now();
    String createdBy = "AdminServer";

    Category category = new Category();
    category.setTitle(title);
    category.setType(type);
    category.setCreatedAt(localDateTime);
    category.setCreatedBy(createdBy);

    Category createdCategory = categoryRepository.save(category);
    Assertions.assertNotNull(createdCategory);
    Assertions.assertEquals(type, createdCategory.getType());
    Assertions.assertEquals(title, createdCategory.getTitle());
  }

  @Test
  void read() {
    // ID Test
    Optional<Category> category = categoryRepository.findById(1L);
    Assertions.assertTrue(category.isPresent());
    Category selectCategory = category.get();
    Assertions.assertEquals(1L, selectCategory.getId());

    // Type Test
    String type = "COMPUTER";
    category = categoryRepository.findByType(type);
    Assertions.assertTrue(category.isPresent());
    selectCategory = category.get();
    Assertions.assertEquals(type, selectCategory.getType());
  }
}
