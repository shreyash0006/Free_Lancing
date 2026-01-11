package com.example.demo.controller;

import com.example.demo.io.Orderresp;
import com.example.demo.io.Razorpayreq;
import com.example.demo.io.Razorpayresp;
import com.example.demo.io.paymentverifyreq;
import com.example.demo.service.Razorpayservice;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class RazorpayController {

    @Autowired
    Razorpayservice Rserv;
    @PostMapping
    public Razorpayresp create(@RequestBody Razorpayreq req) throws RazorpayException {
       return Rserv.createOrder(req.getAmount(), req.getCurrency());
    }
    @PostMapping("/verify")
    public Orderresp verify(@RequestBody  paymentverifyreq req)
    {
        return Rserv.verify((req));
    }
}
