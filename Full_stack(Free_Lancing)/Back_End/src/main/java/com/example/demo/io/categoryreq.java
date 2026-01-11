package com.example.demo.io;

public class categoryreq{
	String name;
	String description;

	public categoryreq() {
	}

	public categoryreq(String name, String description, String bgcolor) {
		this.name = name;
		this.description = description;
		this.bgcolor = bgcolor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBgcolor() {
		return bgcolor;
	}

	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}

	String bgcolor;

}