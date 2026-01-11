package com.example.demo.io;


import jakarta.persistence.Embedded;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class Ordereq{
        String name;
        String customername;
        String phone_number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public List<Orderitemsreq> getCartitems() {
        return cartitems;
    }

    public void setCartitems(List<Orderitemsreq> cartitems) {
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

        String paymentmethod;
        List<Orderitemsreq> cartitems=new ArrayList<>();
        double total;
        double subtotal;
        double tax;

    public paymentdetails getPaymentdetails() {
        return paymentdetails;
    }

    public void setPaymentdetails(paymentdetails paymentdetails) {
        this.paymentdetails = paymentdetails;
    }

    @Embedded
        paymentdetails paymentdetails;
        @Builder
        public static class Orderitemsreq{
            String itemid;

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

            String name;
            double price;
            Integer qty;
        }
}