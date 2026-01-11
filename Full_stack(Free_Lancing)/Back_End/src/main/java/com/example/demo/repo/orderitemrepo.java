package com.example.demo.repo;

import com.example.demo.entity.Orderitems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderitemrepo extends JpaRepository<Orderitems,Long> {
}