package com.example.demo.service;

import com.example.demo.entity.user;
import com.example.demo.io.Authreq;
import com.example.demo.io.usereq;
import com.example.demo.io.useresp;
import com.example.demo.repo.usereepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class userservice {
    @Autowired
    usereepo repo;
    @Autowired
    PasswordEncoder pass;
    public void delete(String id)
    {
        user u=repo.findByUserid(id).orElseThrow(()-> new UsernameNotFoundException("not found the fuckin user"));
        repo.delete(u);
    }
    public List<useresp> getAll()
    {
        List<useresp> l=repo.findAll().stream().map(use->ConToRes(use)).collect(Collectors.toList());
        return l;
    }
    public String getrole(String email)
    {
        user u=repo.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("user not found"));
        return u.getRole();
    }
    public useresp createuser(usereq req)
    {
        user u=ConToEnt(req);
       user k= repo.save(u);
       return ConToRes(k);
    }

    private useresp ConToRes(user k) {
        return useresp.builder().role(k.getRole()).name(k.getName())
                .email(k.getEmail()).password(k.getPassword())
                .userid(k.getUserid()).
                crAt(k.getCrAt()).upAt(k.getUpAt()).build();
    }

    private user ConToEnt(usereq req) {
        return user.builder().Role(req.getRole()).name(req.getName())
                .email(req.getEmail()).password(pass.encode(req.getPassword()))
                .userid(UUID.randomUUID().toString()).build();
    }
}
