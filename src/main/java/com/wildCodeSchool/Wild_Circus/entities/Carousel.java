package com.wildCodeSchool.Wild_Circus.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Carousel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long orderNumber;
	@Lob
	private String title;
	@Lob
	private String description;
	@Lob
	private String picture;

	
	public Carousel() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getPicture() {
		return picture;
	}
	
	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
