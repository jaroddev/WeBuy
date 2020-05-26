package com.example.webay2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class ImagesPointer implements Serializable {

	private Long id;


	private List<Image> images = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public void addImage(Image image) {
		this.images.add(image);
	}

	public void removeImage(Long imageId) {
		for (Image image : this.images)
			if (image.getId().equals(imageId))
				this.images.remove(image);
	}

}
