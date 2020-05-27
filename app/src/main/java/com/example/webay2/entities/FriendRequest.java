package com.example.webay2.entities;

import java.io.Serializable;



public class FriendRequest implements Serializable {


	private Long id;
	private User sender;
	private User receiver;

	public Long getId() {
		return id;
	}
	 public void setId(Long id) { this.id = id; }
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

}
