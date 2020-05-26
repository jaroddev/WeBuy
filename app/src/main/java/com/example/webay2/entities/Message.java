package com.example.webay2.entities;

import java.io.Serializable;
import java.util.Date;



public class Message implements Serializable {

	private static final long serialVersionUID = 289007841462112538L;


	private Long id;


	private User creator;

	private Date createdAt;


	private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) { this.id = id; }


	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
