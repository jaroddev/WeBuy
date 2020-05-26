package com.example.webay2.entities;

import java.io.Serializable;



public class ShopGroup implements Serializable {

	private Long id;
	private String name;


	private Image logo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

}
