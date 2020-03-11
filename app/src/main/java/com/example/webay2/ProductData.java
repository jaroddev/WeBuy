package com.example.webay2;

import java.util.List;

public class ProductData {
    private String name;
    private String description;
    private List<Integer> images;
    private int id;

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    private int idShop;
    private double price;
    private double discountPrice;
    private String comment;


    public ProductData(String name, double price, double discountPrice, String comment) {
        this.name = name;
        this.discountPrice = discountPrice;
        this.price = price;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getImages()
    {
        return images;
    }

    public void setImages(List<Integer> images) {
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
