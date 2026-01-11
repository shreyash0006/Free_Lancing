package com.example.demo.repo;

import com.example.demo.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface orderrepo extends JpaRepository<Orders,Long> {
    Optional<Orders> findByOrderid(String id);
    List<Orders> findByOrderByCreatedAtDesc();

    @Query("SELECT SUM(o.total) FROM Orders o WHERE o.createdAt = :date")
    Double todaysales(@Param("date")LocalDate date);

    @Query("SELECT COUNT(o) FROM Orders o WHERE o.createdAt = :date")
    Integer todaycount(@Param("date")LocalDate date);

    @Query("SELECT o FROM Orders o WHERE o.createdAt = :date ORDER BY o.createdAt DESC")
    List<Orders> getOrdersByDate(@Param("date") LocalDate date);
}
