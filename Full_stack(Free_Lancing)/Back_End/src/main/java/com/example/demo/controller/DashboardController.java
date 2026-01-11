package com.example.demo.controller;

import com.example.demo.io.Orderresp;
import com.example.demo.io.dashboardresp;
import com.example.demo.service.orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    orderservice serv;
    @GetMapping
    public dashboardresp dash()
    {
        LocalDate g=LocalDate.now();
        Double amount=serv.todayamount(g);
        Integer count=serv.countorder(g);
        List<Orderresp> or=serv.gettodaysorder(g);
        return dashboardresp.builder().
                todaysales(amount)
                .todaycount(count)
                .orders(or)
                .build();
    }
}
