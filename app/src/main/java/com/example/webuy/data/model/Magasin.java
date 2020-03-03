package com.example.webuy.data.model;

import java.util.ArrayList;
import java.util.List;

// Setters not needed cause only admin can edit a Magasin info
// And only through the web app
public class Magasin {

    private List<String> offers;

    private Integer id;

    private String image;

    private String name;

    private String address;

    public Magasin(int id, String image, String name, String address){
        // id greater than 1
        this.id = id < 1 ? 1 : id;

        this.name = name;
        this.address = address;

        // Initialize offers
        this.offers = new ArrayList<>();
    }

    public Magasin(int id,String image, String name, String address, List<String> offers){
        this(id, image, name, address);
        this.offers = offers;
    }

    // A function meant to mock an image database
    public static String getImageById(int id){
        String image;

        if(id == 1 || id == 4){
            image = "One or Four";
        }else if(id == 2){
            image = "Two";
        }else {
            image = "Not One Not Two Not Four";
        }

        return image;
    }

    // A function meant to mock a name database
    public static String getNameById(int id){
        String name;

        if(id == 1 || id == 4){
            name = "Carrefour";
        }else if(id == 2){
            name = "Auchan";
        }else {
            name = "Un autre Magasin";
        }

        return name;
    }

    // A function meant to mock an address database
    public static String getAddressById(int id){
        String address;

        if(id == 1 || id == 4){
            address = "La rue de carrefour, 50500 CarrefourCity";
        }else if(id == 2){
            address = "Le Boulevard Auchan, 10420 AuchanCity";
        }else {
            address = "Une impasse, 00000 JeSaisPasOu";
        }

        return address;
    }

    // A function meant to mock an offer database
    // Returns empty list if id is 2
    public static List<String> getOffersById(int id){
        List<String> offers = new ArrayList<>();

        if(id == 1 || id == 4){
            offers.add("Citron bio");
            offers.add("Kinder Bueno");
        }else if(id != 2){
            offers.add("Un produit au hasard");
        }

        return offers;
    }

    // Use the database mocking functions to mock a magasin database
    public static Magasin getMagasinById(int id){
        String name = Magasin.getNameById(id);
        String image = Magasin.getImageById(id); ;
        String address = Magasin.getAddressById(id); ;
        List<String> offers = Magasin.getOffersById(id);

        return new Magasin(id, name, image, address, offers);
    }


    // Return offers
    // Needed when displaying offers of a magasins/shop
    public List<String> getOffers(){
        return this.offers;
    }

    // Can add offer from the app
    public void add(String offer){
        offers.add(offer);
    }

    // Can remove offer once everyone paid
    public void remove(String offer){
        offers.remove(offer);
    }

    // return the number of offers
    // If 0 then shop not listed ?? displayed ??
    public int getOfferCount(){
        int offerCount;
        if(offers == null){
            offerCount = 0;
        }else {
            offerCount = offers.size();
        }

        return offerCount;

    }

    public String getName(){
        return this.name;
    }


    public String getAddress(){
        return this.address;
    }

}
