package com.example.demo.repo;

import com.example.demo.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface usereepo extends JpaRepository<user,Long> {
    Optional<user> findByEmail(String email);
    Optional<user> findByUserid(String id);
}
