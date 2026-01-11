package com.example.demo.io;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class itemsresp {
    String itemid;
    String name;

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    String imgurl;
    String description;
    Timestamp crAt;
    Timestamp upAt;
    BigDecimal price;
    String categoryid;
    String categoryname;
}
