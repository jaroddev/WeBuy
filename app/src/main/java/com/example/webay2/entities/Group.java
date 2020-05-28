package com.example.webay2.entities;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.Collection;




public class Group implements Serializable {

	@Expose
	private Long id;


	private User leader;


	private Collection<User> members;

	@Expose
	private Collection<Message> messages;


	private Offer offer;

	public Long getId() {
		return id;
	}


	  public void setId(Long id) { this.id = id; }


	public User getLeader() {
		return leader;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}

	public Collection<User> getMembers() {
		return members;
	}

	public void setMembers(Collection<User> members) {
		this.members = members;
	}

	public Collection<Message> getMessages() {
		return messages;
	}

	public void setChat(Collection<Message> messages) {
		this.messages = messages;
	}

	public void addChat(Message message) {
		messages.add(message);
	}

	public void removeChat(Long messageId) {
		this.messages.removeIf(chat -> chat.getId().equals(messageId));
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

}
