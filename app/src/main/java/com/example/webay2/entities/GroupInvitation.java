package com.example.webay2.entities;

import java.io.Serializable;



public class GroupInvitation implements Serializable {


	private Long id;



	private User sender;


	private User receiver;

	private Group group;

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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
