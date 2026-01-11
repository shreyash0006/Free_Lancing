package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.repo.catRepo;
import com.example.demo.io.categoryreq;
import com.example.demo.io.categoryres;
import com.example.demo.service.categoryservice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CatController {
	@Autowired
	catRepo repo;
    @Autowired
    categoryservice ser;
  @GetMapping("/admin/categories")
  public List<Category> get()
  {
	 List<Category> l= repo.findAll();
      System.out.println("hi i am"+System.currentTimeMillis());
	  return l;
  }
    @PostMapping("/admin/categories")
    public categoryres put(@RequestPart("category") String category,@RequestPart("file") MultipartFile f)
    {
        ObjectMapper map=new ObjectMapper();
        categoryreq rq=null;
            try{
                rq=map.readValue(category,categoryreq.class);
                return ser.add(rq,f);
            }
            catch(Exception e)
            {
                    System.out.println("e");
            }
    return null;
    }
    @DeleteMapping("/admin/categories/{id}")
    public void dele(@PathVariable("id") String id){
            ser.deleteCategory(id);
    }
  
}
