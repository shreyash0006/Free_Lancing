package com.example.demo.io;

import lombok.*;

import java.sql.Timestamp;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class categoryres {
	String catid;
	String name;
	String description;
	String bgcolor;
	String imgurl;
	Timestamp crAt;
	Timestamp upAt;
	int id;
}
