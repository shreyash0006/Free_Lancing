package com.example.demo.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class useresp {
    String userid;
    String role;
    String name;
    String email;
    String password;
    @CreationTimestamp
    Timestamp crAt;

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getUserid() {
        return userid;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
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

    @UpdateTimestamp
    Timestamp upAt;
}
