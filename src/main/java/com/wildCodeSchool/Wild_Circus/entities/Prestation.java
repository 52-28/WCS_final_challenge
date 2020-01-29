package com.wildCodeSchool.Wild_Circus.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;


@Entity
public class Prestation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Lob
	private String description;
	@Lob
	private String title;
	private String city;
	private int price;
	private double maxPlaces;
	private Date representationDate;
	private String gps;
	@ManyToMany
	private List<Trick> tricks;

	
	public Prestation() {
	}


	public String getDescription() {
		return description;
	}


	public String getTitle() {
		return title;
	}


	public String getCity() {
		return city;
	}


	public int getPrice() {
		return price;
	}


	public double getMaxPlaces() {
		return maxPlaces;
	}


	public Date getRepresentationDate() {
		return representationDate;
	}


	public String getGps() {
		return gps;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public void setMaxPlaces(double maxPlaces) {
		this.maxPlaces = maxPlaces;
	}


	public void setRepresentationDate(Date representationDate) {
		this.representationDate = representationDate;
	}


	public void setGps(String gps) {
		this.gps = gps;
	}


	public List<Trick> getTricks() {
		return tricks;
	}


	public void setTricks(List<Trick> tricks) {
		this.tricks = tricks;
	}

	
}
