package com.example.webay2.entities;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.Date;



public class Message implements Serializable {

	private static final long serialVersionUID = 289007841462112538L;

	@Expose
	private Long id;

	@Expose
	private User creator;
	@Expose
	private Date createdAt;

	@Expose
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
