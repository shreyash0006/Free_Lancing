package com.example.demo.controller;

import com.example.demo.io.Ordereq;
import com.example.demo.io.Orderresp;
import com.example.demo.service.orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    orderservice Oserv;
    @PostMapping
    public Orderresp create(@RequestBody Ordereq req)
    {
        try{
            return Oserv.createorder(req);
        }
        catch (Exception e)
        {
            throw new RejectedExecutionException("Could not able to create "+e);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id)
    {
        Oserv.deleteorder(id);
    }

    @GetMapping
    public List<Orderresp> getallorder(){

        System.out.println("hi "+ LocalDate.now());
        return Oserv.getallorrder();
    }
}
