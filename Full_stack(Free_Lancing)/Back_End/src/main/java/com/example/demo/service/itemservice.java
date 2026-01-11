package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.items;
import com.example.demo.io.itemsreq;
import com.example.demo.io.itemsresp;
import com.example.demo.repo.catRepo;
import com.example.demo.repo.itemrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class itemservice {
    @Autowired
    itemrepo repo;
    @Autowired
    catRepo crepo;
    public itemsresp add(itemsreq req, MultipartFile file) throws IOException {
       String filename= UUID.randomUUID().toString()+"."+ StringUtils.getFilenameExtension(file.getOriginalFilename());
       Path p= Paths.get("uploadsitems").toAbsolutePath().normalize();
        Files.createDirectories(p);
        Path tgloc=p.resolve(filename);
        Files.copy(file.getInputStream(),tgloc, StandardCopyOption.REPLACE_EXISTING);
        String imgurl="http://localhost:8080/uploadsitems/"+filename;
        items entity=conToEn(req);
        entity.setImgurl(imgurl);
        Category cat=crepo.findByCatid(req.getCategoryid()).orElseThrow(()->new RuntimeException("the category is not found"));
        entity.setCategory(cat);
        items g=repo.save(entity);
        itemsresp i=conToresp(g);
        return i;
    }

    private itemsresp conToresp(items e) {
    return itemsresp.builder()
            .name(e.getName())
            .imgurl(e.getImgurl())
            .description(e.getDescription())
            .price(e.getPrice())
            .crAt(e.getCrAt())
            .upAt(e.getUpAt())
            .itemid(e.getItemid())
            .categoryid(e.getCategory().getCatid())
        .categoryname(e.getCategory().getName())
            .build();
    }

    private items conToEn(itemsreq req) {
        return items.builder().name(req.getName()).description(req.getDescription())
             .price(req.getPrice()).itemid(UUID.randomUUID().toString()).build();
    }

    public void delete(String id)
    {
        items e=repo.findByItemid(id).orElseThrow(()->new UsernameNotFoundException("cant find the data of the user in teh database"));
        repo.delete(e);
    }
    public List<itemsresp> getAllitems()
    {
        return repo.findAll().stream().map(e->conToresp(e)).collect(Collectors.toList());
    }
    public int itemnumber(int catid)
    {
        try{
            return repo.countByCategory_Id(catid);
        }
        catch(Exception e)
        {
            throw  new UsernameNotFoundException("cant find the category" +e);
        }

    }
    public List<itemsresp> getpartitem(int id)
    {
        List<itemsresp>  l=repo.findByCategory_Id(id).stream().map(e->conToresp(e)).collect(Collectors.toList());
        return l;
    }
}
