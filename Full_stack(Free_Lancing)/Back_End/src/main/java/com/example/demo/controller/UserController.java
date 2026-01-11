package com.example.demo.controller;

import com.example.demo.io.usereq;
import com.example.demo.io.useresp;
import com.example.demo.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserController {
    @Autowired
    userservice  userserv;
    @PostMapping("/register")
    public useresp get(@RequestBody usereq req)
    {
        useresp u=userserv.createuser(req);
        return u;
    }
    @GetMapping("/users")
    public List<useresp> getAll()
    {
        return userserv.getAll();
    }
    @DeleteMapping("/delete/{id}")
    public void delte(@PathVariable("id") String id)
    {
        try{
            userserv.delete(id);
        }
        catch (Exception e)
        {
            throw new UsernameNotFoundException("sorry can ble to find the user int the database");
        }
    }
}
