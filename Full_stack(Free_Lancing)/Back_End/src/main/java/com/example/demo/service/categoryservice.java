package com.example.demo.service;


import com.example.demo.entity.Category;
import com.example.demo.repo.catRepo;
import com.example.demo.io.categoryreq;
import com.example.demo.io.categoryres;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class categoryservice {

    @Autowired
    catRepo cat;
    public categoryres add(categoryreq req, MultipartFile file) throws IOException
    {
       String filename= UUID.randomUUID().toString()+"."+ StringUtils.getFilenameExtension(file.getOriginalFilename());
       Path p= Paths.get("uploads").toAbsolutePath().normalize();
        Files.createDirectories(p); 
        Path tgloc=p.resolve(filename);
        Files.copy(file.getInputStream(),tgloc, StandardCopyOption.REPLACE_EXISTING);
        String imgurl="http://localhost:8080/uploads/"+filename;
        Category newcat=converttoEntity(req);
        newcat.setImgurl(imgurl);
        newcat.setCatid(filename.substring(0,filename.indexOf(".")));
        cat.save(newcat);
        return converttores(newcat);
    }
    public Category converttoEntity(categoryreq req)
    {
        return Category.builder()
                .name(req.getName())
                .description(req.getDescription())
                .bgcolor(req.getBgcolor())
                .build();
    }
    public categoryres converttores(Category en) {
        return categoryres.builder()
                .name(en.getName())
                .description(en.getDescription())
                .bgcolor(en.getBgcolor())
                .imgurl(en.getImgurl())
                .catid(en.getCatid())
                .upAt(en.getUpAt())
                .crAt(en.getCrAt())
                .id(en.getId())
                .build();
    }
    @Transactional
    public void deleteCategory(String catid) {
         cat.deleteByCatid(catid);  // Spring Data JPA will run this inside a transaction
    }

}
