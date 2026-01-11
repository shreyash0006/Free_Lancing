package com.example.demo.io;

import jakarta.persistence.Embeddable;

@Embeddable
public class paymentdetails{
    String razorpayorderid;
    String razorpaypaymentmethod;
    String razorpaysignature;

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

    public String getRazorpaysignature() {
        return razorpaysignature;
    }

    public void setRazorpaysignature(String razorpay) {
        this.razorpaysignature = razorpay;
    }
}