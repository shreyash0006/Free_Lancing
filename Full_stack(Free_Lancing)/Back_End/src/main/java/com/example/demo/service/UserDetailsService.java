package com.example.demo.service;

import com.example.demo.entity.user;
import com.example.demo.repo.usereepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    usereepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user e = repo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("not found the username in the database"));
        return new User(e.getEmail(), e.getPassword(), Collections.singleton(new SimpleGrantedAuthority(e.getRole())));
    }
}
