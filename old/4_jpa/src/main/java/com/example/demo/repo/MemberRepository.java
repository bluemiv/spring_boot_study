package com.example.demo.repo;

import com.example.demo.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    // pid를 이용하여 조회
    List<MemberEntity> findByPid(String pid);

    // username을 이용하여 조회
    List<MemberEntity> findByUsername(String username);

    // name을 이용하여 조회
    List<MemberEntity> findByName(String name);

    // Like 문 사용
    List<MemberEntity> findByNameLike(String name);
}
