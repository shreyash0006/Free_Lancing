package com.example.demo.io;

import jakarta.persistence.Embedded;
import lombok.Builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
public class Orderresp{
    String orderid;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }


    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    String customername;

    LocalDate time;

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public List<Orderitemsresp> getCartitems() {
        return cartitems;
    }

    public void setCartitems(List<Orderitemsresp> cartitems) {
        this.cartitems = cartitems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    String phone_number;
    String paymentmethod;
    List<Orderitemsresp> cartitems=new ArrayList<>();
    double total;
    double subtotal;
    double tax;
    @Embedded
    paymentdetails paymentdetails;
    public paymentdetails getPaymentdetails() {
        return paymentdetails;
    }

    public void setPaymentdetails(paymentdetails paymentdetails) {
        this.paymentdetails = paymentdetails;
    }
    @Builder
    public static class Orderitemsresp{
        String itemid;
        String name;

        public String getItemid() {
            return itemid;
        }

        public void setItemid(String itemid) {
            this.itemid = itemid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public Integer getQty() {
            return qty;
        }



        public void setQty(Integer qty) {
            this.qty = qty;
        }

        double price;
        Integer qty;
    }
}