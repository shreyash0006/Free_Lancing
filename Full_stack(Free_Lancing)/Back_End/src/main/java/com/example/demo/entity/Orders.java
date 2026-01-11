package com.example.demo.entity;

import com.example.demo.io.paymentdetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String orderid;
    String customername;
    String phone_number;
    LocalDate createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<Orderitems> getCartitems() {
        return cartitems;
    }

    public void setCartitems(List<Orderitems> cartitems) {
        this.cartitems = cartitems;
    }

    double tax;
    double subtotal;
    double total;
    String paymentMethod;
    @OneToMany(cascade = CascadeType.ALL)
            @JoinColumn(name="Ofg_tbl")
    List<Orderitems> cartitems=new ArrayList<>();

    public paymentdetails getDetails() {
        return details;
    }


    public void setDetails(paymentdetails details) {
        this.details = details;
    }

    @Embedded
    paymentdetails details;
    @PrePersist
    protected void create()
    {
        this.createdAt= LocalDate.now();
        this.orderid="ORD"+System.currentTimeMillis();
    }
}