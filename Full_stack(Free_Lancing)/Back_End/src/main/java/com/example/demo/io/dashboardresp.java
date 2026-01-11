package com.example.demo.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class dashboardresp {
    Double todaysales;

    public Double getTodaysales() {
        return todaysales;
    }

    public void setTodaysales(Double todaysales) {
        this.todaysales = todaysales;
    }

    public Integer getTodaycount() {
        return todaycount;
    }

    public void setTodaycount(Integer todaycount) {
        this.todaycount = todaycount;
    }

    public List<Orderresp> getOrders() {
        return orders;
    }

    public void setOrders(List<Orderresp> orders) {
        this.orders = orders;
    }

    Integer todaycount;
    List<Orderresp> orders=new ArrayList<>();
}
