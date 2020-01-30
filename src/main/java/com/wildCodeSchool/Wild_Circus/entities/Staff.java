package com.wildCodeSchool.Wild_Circus.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Lob
	private String name;
	@Lob
	private String description;
	@Lob
	private String title;
	@Lob
	private String picture;
	private String videoLink;
	@OneToMany(mappedBy = "staff")
	private List<Trick> tricks;	
	
	public Staff() {
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getPicture() {
		return picture;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Trick> getTricks() {
		return tricks;
	}

	public void setTricks(List<Trick> tricks) {
		this.tricks = tricks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
