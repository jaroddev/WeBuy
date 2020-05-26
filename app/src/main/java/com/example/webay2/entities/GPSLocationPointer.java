package com.example.webay2.entities;

import java.io.Serializable;



public class GPSLocationPointer implements Serializable {
	

	private Long id;


	private Location location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
