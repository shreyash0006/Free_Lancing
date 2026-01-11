package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	public String getCatid() {
		return catid;
	}

	public String getName() {
		return name;
	}

	public String getImgurl() {
		return imgurl;
	}

	public String getBgcolor() {
		return bgcolor;
	}

	public String getDescription() {
		return description;
	}

	public Timestamp getCrAt() {
		return crAt;
	}

	public Timestamp getUpAt() {
		return upAt;
	}

	private String catid;
	private String name;
	private String imgurl;
	private String bgcolor;
	private String description;

	@CreationTimestamp
	private Timestamp crAt;

	@UpdateTimestamp
	private Timestamp upAt;
}
