package com.example.demo.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class paymentverifyreq {
    String razorpaysignature;
    String razorpayorderid;

    public String getRazorpaysignature() {
        return razorpaysignature;
    }

    public void setRazorpaysignature(String razorpaysignature) {
        this.razorpaysignature = razorpaysignature;
    }

    public String getRazorpayorderid() {
        return razorpayorderid;
    }

    public void setRazorpayorderid(String razorpayorderid) {
        this.razorpayorderid = razorpayorderid;
    }

    public String getRazorpaypaymentmethod() {
        return razorpaypaymentmethod;
    }

    public void setRazorpaypaymentmethod(String razorpaypaymentmethod) {
        this.razorpaypaymentmethod = razorpaypaymentmethod;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    String razorpaypaymentmethod;
    String orderid;
}
