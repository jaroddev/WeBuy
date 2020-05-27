package com.example.webay2.entities;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.Collection;





public class User implements Serializable {

	@Expose
	private Long id;
	@Expose
	private String email;
	@Expose
	private String phoneNumber;
	@Expose
	private String password;
	@Expose
	private String role;
	@Expose
	private String name;
	private GPSLocationPointer gpsLocationPointer;

	// Define the user to other user

	private Collection<User> friends;

	private Collection<FriendRequest> sentFriendRequests;


	private Collection<FriendRequest> receivedFriendRequests;


	private Collection<Group> groups;


	private Collection<Group> groupsCreate;


	private Collection<GroupInvitation> sentGroupInvitations;


	private Collection<GroupInvitation> receivedGroupInvitations;

	public Long getId() {
		return id;
	}


	 public void setId(Long id) { this.id = id; }


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public GPSLocationPointer getGPSLocationPointer() {
		return gpsLocationPointer;
	}

	public void setGPSLocationPointer(GPSLocationPointer gpsLocationPointer) {
		this.gpsLocationPointer = gpsLocationPointer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<User> getFriends() {
		return friends;
	}

	public void setFriends(Collection<User> friends) {
		this.friends = friends;
	}

	public void addFriends(User friend) {
		this.friends.add(friend);
		friend.addFriends(this);
	}

	public Collection<FriendRequest> getSentFriendRequests() {
		return sentFriendRequests;
	}

	public void setSentFriendRequests(Collection<FriendRequest> sentFriendRequests) {
		this.sentFriendRequests = sentFriendRequests;
	}

	public void addSentFriendRequest(User friend) {
		FriendRequest friendRequest = new FriendRequest();
		friendRequest.setSender(this);
		friendRequest.setReceiver(friend);
		this.sentFriendRequests.add(friendRequest);
	}

	public void removeSentFriendRequest(Long sentFriendRequestId) {
		for (FriendRequest friendRequest : this.sentFriendRequests)
			if (friendRequest.getId().equals(sentFriendRequestId))
				this.sentFriendRequests.remove(friendRequest);
	}

	public Collection<FriendRequest> getReceivedFriendRequests() {
		return receivedFriendRequests;
	}

	public void setReceivedFriendRequests(Collection<FriendRequest> receivedFriendRequests) {
		this.receivedFriendRequests = receivedFriendRequests;
	}

	public void addReceivedFriendRequest(User friend) {
		FriendRequest friendRequest = new FriendRequest();
		friendRequest.setSender(friend);
		friendRequest.setReceiver(this);
		this.sentFriendRequests.add(friendRequest);
	}

	public void removeReceivedFriendRequest(Long receivedFriendRequestId) {
		for (FriendRequest friendRequest : this.receivedFriendRequests)
			if (friendRequest.getId().equals(receivedFriendRequestId))
				this.receivedFriendRequests.remove(friendRequest);
	}

	public Collection<Group> getGroups() {
		return groups;
	}

	public void setGroups(Collection<Group> groups) {
		this.groups = groups;
	}

	public Collection<Group> getGroupsCreate() {
		return groupsCreate;
	}

	public void setGroupsCreate(Collection<Group> groupsCreate) {
		this.groupsCreate = groupsCreate;
	}

	public Collection<GroupInvitation> getSentGroupInvitations() {
		return sentGroupInvitations;
	}

	public void setSentGroupInvitations(Collection<GroupInvitation> sentGroupInvitations) {
		this.sentGroupInvitations = sentGroupInvitations;
	}

	public Collection<GroupInvitation> getReceivedGroupInvitations() {
		return receivedGroupInvitations;
	}

	public void setReceivedGroupInvitations(Collection<GroupInvitation> receivedGroupInvitations) {
		this.receivedGroupInvitations = receivedGroupInvitations;
	}

}
