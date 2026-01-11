package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class items {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;

    @Column(unique=true)
    String itemid;
    public void setId(long id) {
        this.id = id;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCrAt(Timestamp crAt) {
        this.crAt = crAt;
    }

    public void setUpAt(Timestamp upAt) {
        this.upAt = upAt;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    String name;
    String description;

    public Timestamp getCrAt() {
        return crAt;
    }

    public long getId() {
        return id;
    }

    public String getItemid() {
        return itemid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getUpAt() {
        return upAt;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @CreationTimestamp
    Timestamp crAt;
    @UpdateTimestamp
    Timestamp upAt;
    String imgurl;
    BigDecimal price;
    @ManyToOne
            @JoinColumn(name="category_id")
            @OnDelete(action= OnDeleteAction.RESTRICT)
    Category category;
}

