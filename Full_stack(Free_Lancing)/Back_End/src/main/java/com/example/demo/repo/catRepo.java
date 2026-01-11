package com.example.demo.repo;

import com.example.demo.entity.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface catRepo extends JpaRepository<Category,Integer>{
	@Modifying
	@Transactional
	void deleteByCatid(String id);
	Optional<Category> findByCatid(String id);
}
