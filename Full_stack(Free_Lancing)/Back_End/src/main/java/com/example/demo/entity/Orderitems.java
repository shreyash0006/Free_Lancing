package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Orderitems{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemname() {
        return name;
    }

    public void setItemname(String itemname) {
        this.name = itemname;
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

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    String name;
    double price;
    Integer qty;
    String itemid;
}