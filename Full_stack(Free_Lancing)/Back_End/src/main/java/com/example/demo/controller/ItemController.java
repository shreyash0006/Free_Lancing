package com.example.demo.controller;

import com.example.demo.io.itemsreq;
import com.example.demo.io.itemsresp;
import com.example.demo.service.itemservice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    itemservice serv;
    @GetMapping("/getitems")
    public List<itemsresp> get()
    {
     List<itemsresp> l=serv.getAllitems();
        return l;
    }

    @PostMapping("/admin/additem")
    public itemsresp additem(@RequestPart("item") String it, @RequestPart("file")MultipartFile file)
    {
        ObjectMapper obj=new ObjectMapper();
        itemsreq req=null;
        itemsresp resp=null;
        try{
             req=obj.readValue(it,itemsreq.class);
            resp= serv.add(req,file);
        }
        catch(Exception e)
        {
            throw(new RuntimeException("can t add teh item"+e));
        }
        return resp;
    }
    @DeleteMapping("/admin/deleteitem/{id}")
    public void del(@PathVariable("id") String id)
    {
        serv.delete(id);
    }
    @GetMapping("/admin/itemnumbers/{id}")
    public int gettotal(@PathVariable("id") int catid )
    {
        System.out.print("hello sir hi "+serv.itemnumber(catid)+"   ");
          return serv.itemnumber(catid);
    }
    @GetMapping("/admin/partitem/{id}")
    public List<itemsresp> getparti(@PathVariable("id") int id)
    {
        List<itemsresp> l= serv.getpartitem(id);
        if(l.size()==0)return null;
        return l;
    }
}
