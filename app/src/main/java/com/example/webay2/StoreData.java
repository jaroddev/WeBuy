package com.example.webay2;

import android.location.Location;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StoreData implements Serializable {

    private String name;
    private String description;
    private int image;
    private int id;
    private int logo;
    Location location;
    List<ProductData> productDataList;




    public StoreData(String shopName, String shopDescription, int shopImage) {
        this.productDataList = new ArrayList<>();
        this.name = shopName;
        this.description = shopDescription;
        this.image = shopImage;
    }

    public StoreData(int id, String name, String description, int image, int logo) {
        this.productDataList = new ArrayList<>();
        this.name = name;
        this.description = description;
        this.image = image;
        this.logo = logo;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setProductDataList(List<ProductData> productDataList) {
        this.productDataList = productDataList;
    }
    public void addProductData(ProductData shopItem) {
        this.productDataList.add(shopItem);
    }

    public List<ProductData> getProductDataList() {
        return productDataList;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
