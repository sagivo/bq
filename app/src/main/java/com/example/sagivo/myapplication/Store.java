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
                new Store("East Village (300 ft)", "store1", "", true),
                new Store("West Village (0.3 mile)", "store2", "", true),
                new Store("Washington Sq. Park (0.6 mile)", "store3", "", false),
                new Store("Midtown West (1.1 miles)", "store4", "", true),
                new Store("2nd Ave. (1.3 mile)", "store5", "", true),
                new Store("Broadway (1.7 mile)", "store6", "", true),
                new Store("Brooklyn. (2.1 mile)", "store7", "7th Ave", true),
                new Store("Chinatown (3.3 mile)", "store1", "", true),
                new Store("5th street (7 mile)", "store2", "", true),
                new Store("Downtown (10.7 mile)", "store3", "", true),
                new Store("Times Sq. (11.4 mile)", "store4", "7th Ave", true),
                new Store("Brooklyn. (15.3 mile)", "store7", "7th Ave", true),
                new Store("East Village", "store1", "", true),
                new Store("West Village", "store2", "", true),
                new Store("Washington Sq. Park", "store3", "", false),
                new Store("Midtown West", "store4", "", true),
                new Store("2nd Ave.", "store5", "", true),
                new Store("Broadway", "store6", "", true),
                new Store("Chinatown", "store1", "", true),
                new Store("5th street", "store2", "", true),
                new Store("Brooklyn.", "store7", "7th Ave", true),
                new Store("Downtown", "store3", "", true),
                new Store("Times Sq.", "store4", "7th Ave", true)
        };
    }
}