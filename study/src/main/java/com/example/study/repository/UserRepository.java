package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { // <엔티티, 기본키의 타입>

  // select * from user where account = ?;
  Optional<User> findByAccount(String account);

  // select * from user where email = ?;
  Optional<User> findByEmail(String email);

  // select * from user where account = ? and email = ?
  Optional<User> findByAccountAndEmail(String account, String email);
}
