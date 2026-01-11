package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class user {
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        Role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCrAt(Timestamp crAt) {
        this.crAt = crAt;
    }

    public void setUpAt(Timestamp upAt) {
        this.upAt = upAt;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(unique=true)
    String userid;
    @Column(unique = true)
    String email;

    public Long getId() {
        return id;
    }

    public String getUserid() {
        return userid;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return Role;
    }

    public String getPassword() {
        return password;
    }

    public Timestamp getCrAt() {
        return crAt;
    }

    public Timestamp getUpAt() {
        return upAt;
    }

    String name;
    String Role;
    String password;
    @CreationTimestamp
    Timestamp crAt;
    @UpdateTimestamp
    Timestamp upAt;
}
