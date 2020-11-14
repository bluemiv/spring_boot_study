package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.AdminUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
public class AdminUserRepositoryTest extends StudyApplicationTests {

  @Autowired private AdminUserRepository adminUserRepository;

  @Test
  @Disabled
  public void create() {
    String account = "AdminUser01";
    String password = "1234";
    String status = "REGISTERED";
    String role = "PARTNER";
    LocalDateTime now = LocalDateTime.now();
    String createdBy = "AdminServer";

    AdminUser adminUser = new AdminUser();
    adminUser.setAccount(account);
    adminUser.setPassword(password);
    adminUser.setStatus(status);
    adminUser.setRole(role);
    adminUser.setCreatedAt(now);
    adminUser.setPasswordUpdatedAt(now);
    adminUser.setCreatedBy(createdBy);

    AdminUser createdAdminUser = adminUserRepository.save(adminUser);
    Assertions.assertNotNull(createdAdminUser);
    Assertions.assertEquals(account, createdAdminUser.getAccount());
    Assertions.assertEquals(password, createdAdminUser.getPassword());
  }

  @Test
  public void read() {
    Optional<AdminUser> adminUser = adminUserRepository.findById(1L);
    Assertions.assertTrue(adminUser.isPresent());
    Assertions.assertEquals(1L, adminUser.get().getId());
  }
}
