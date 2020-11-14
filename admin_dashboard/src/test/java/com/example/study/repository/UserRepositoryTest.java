package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
public class UserRepositoryTest extends StudyApplicationTests {

  @Autowired private UserRepository userRepository;

  @Test
  @Disabled
  public void create() {
    String account = "Test01";
    String password = "1234";
    String status = "REGISTERED";
    String email = "test01@google.com";
    String phoneNumber = "010-1234-5678";
    LocalDateTime now = LocalDateTime.now();
    String createdBy = "AdminServer";

    User user = new User();
    user.setAccount(account);
    user.setPassword(password);
    user.setStatus(status);
    user.setEmail(email);
    user.setPhoneNumber(phoneNumber);
    user.setCreatedAt(now);
    user.setCreatedBy(createdBy);

    User createdUser = userRepository.save(user);
    Assertions.assertNotNull(createdBy);
    Assertions.assertEquals(account, createdUser.getAccount());
    Assertions.assertEquals(password, createdUser.getPassword());
  }

  @Test
  public void read() {
    String phoneNumber = "010-1234-5678";
    Optional<User> user = userRepository.findByPhoneNumber(phoneNumber);
    Assertions.assertTrue(user.isPresent());

    Assertions.assertEquals(phoneNumber, user.get().getPhoneNumber());
  }
}
