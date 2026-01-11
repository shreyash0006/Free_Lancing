package com.example.demo.service;

import com.example.demo.entity.Orderitems;
import com.example.demo.entity.Orders;
import com.example.demo.io.Ordereq;
import com.example.demo.io.Orderresp;
import com.example.demo.io.paymentdetails;
import com.example.demo.repo.orderrepo;
import com.razorpay.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class orderservice{

    @Autowired
    orderrepo orepo;
    public Orderresp createorder(Ordereq req)
    {
        Orders en=convertToEntity(req);
        List<Orderitems> cartitems=req.getCartitems().stream().map((d)->convertToitemEntity(d)).collect(Collectors.toList());
        en.setCartitems(cartitems);
      
       Orders b=orepo.save(en);
       return convertToorderresp(b);
    }

    public Orderresp convertToorderresp(Orders b) {
        return Orderresp.builder()
                .orderid(b.getOrderid())
                .customername(b.getCustomername())
                .phone_number(b.getPhone_number())
                .total(b.getTotal())
                .subtotal(b.getSubtotal())
                .tax(b.getTax())
                .time(b.getCreatedAt())
                .paymentmethod(b.getPaymentMethod())
                .paymentdetails(b.getDetails())
                .cartitems(b.getCartitems()
                        .stream()
                        .map((d)->convertToorderitemresp(d))
                        .collect(Collectors.toList()))
                .build();
    }

    private Orderresp.Orderitemsresp convertToorderitemresp(Orderitems d) {
        return Orderresp.Orderitemsresp.builder().
                name(d.getItemname())
                .itemid(d.getItemid())
                .price(d.getPrice())
                .qty(d.getQty())
                .build();
    }

    private Orderitems convertToitemEntity(Ordereq.Orderitemsreq d) {
        return Orderitems.builder().name(d.getName())
                .itemid(d.getItemid())
                .price(d.getPrice())
                .qty(d.getQty())
                .build();
    }

    private Orders convertToEntity(Ordereq req) {
        return Orders.builder()
                .customername(req.getCustomername())
                .phone_number(req.getPhone_number())
                .tax(req.getTax())
                .subtotal(req.getSubtotal())
                .total(req.getTotal())
                .paymentMethod(req.getPaymentmethod())
                .details(req.getPaymentdetails()==null ? new paymentdetails():null)
                .build();
    }
    public void deleteorder(String id)
    {
        Orders en=orepo.findByOrderid(id).orElseThrow(()->new RuntimeException("not able to find the order"));
        orepo.delete(en);
    }
    public List<Orderresp> getallorrder()
    {
        List<Orders> l= orepo.findByOrderByCreatedAtDesc();
        return l.stream().map((d)->convertToorderresp(d)).collect(Collectors.toList());
    }

    public List<Orderresp> gettodaysorder(LocalDate date) {
//        Pageable pageable = PageRequest.of(0, 5);
        List<Orders> list = orepo.getOrdersByDate(date);
        return list.stream().map(this::convertToorderresp).toList();
    }

    public Integer countorder(LocalDate date)
    {
        return orepo.todaycount(date);
    }
    public Double todayamount(LocalDate date)
    {
        return orepo.todaysales(date);
    }
}