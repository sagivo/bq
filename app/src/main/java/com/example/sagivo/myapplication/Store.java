package com.example.sagivo.myapplication;

public class Store{
    public String name;
    public Boolean open;
    public String address;
    public String image;

    public Store(String name, String image, String address, Boolean open){
        this.name = name; this.image = image; this.address = address; this.open = open;
    }

    public static Store[] getStores(){
        return new Store[]{
                new Store("East Village", "store1", "80 2nd ave", true),
                new Store("West Village", "store2", "80 2nd ave", true),
                new Store("Washington Sq. Park", "store3", "80 2nd ave", true),
                new Store("Midtown West", "store4", "80 2nd ave", true),
                new Store("2nd Ave.", "store5", "80 2nd ave", true),
                new Store("Broadway", "store6", "80 2nd ave", true),
                new Store("Chinatown", "store1", "80 2nd ave", true),
                new Store("5th street", "store2", "80 2nd ave", true),
                new Store("Downtown", "store3", "80 2nd ave", true),
                new Store("Times Sq.", "store4", "7th Ave", true) };
    }
}