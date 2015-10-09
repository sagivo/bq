
//package com.example.sagivo.myapplication;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Lang {

    public static void getItems(String req)
    {
        //String req = "Hello, can i please get a spicy burger, 2 chicken sandwich and 2 coke cold?";

        ArrayList<OrderItem> orders = new ArrayList<OrderItem>();

        String[] _ignore = new String[]{"hi", "hello", "how are you", "thank you", "can", "i", "a", "an", "get", "please", "and", "thanks", "bye" };
        HashSet<String> ignore= new HashSet<String>(Arrays.asList(_ignore));

        String[] _extra = new String[]{ "spicy", "hot", "cold", "neat", "neet" };
        ArrayList<String> extras= new ArrayList<String>(Arrays.asList(_extra));

        Item[] foodItems = {
                new Item("burger", "", 5.99, "b", new String[]{"beef burger", "hamburger", "whopper", "burgers"}),
                new Item("chicken sandwich", "", 4.99, "b", new String[]{"chicken burger", "chicken"}),

                new Item("coke", "", 2.99, "d", new String[]{"cola", "coka cola", "coce", "pepsi"}),
                new Item("sprite", "", 3.99, "d", new String[]{}),

                new Item("fries", "", 1.99, "s", new String[]{"pie"}),
                new Item("apple pie", "", 2.99, "s", new String[]{"pie"}),
                new Item("cheese cake", "", 6.99, "s", new String[]{"cheesecake"})
        };



        HashMap<String, Item> map = new HashMap<String, Item>();
        for(Item i: foodItems)
            for(String name : i.aka)
                map.put(name, i);

        HashMap<String, Integer> nums = new HashMap<String, Integer>();
        nums.put("one",1); nums.put("1",1); nums.put("single",1); nums.put("a",1);
        nums.put("two",2); nums.put("2",2); nums.put("double",2); nums.put("twice",2);
        nums.put("tree",3); nums.put("3",3); nums.put("triple",3);
        nums.put("four",4); nums.put("4",4);
        nums.put("five",5); nums.put("5",5);
        nums.put("six",6); nums.put("6",6);
        nums.put("seven",7); nums.put("7",7);
        nums.put("eight",8); nums.put("8",8);
        nums.put("nine",9); nums.put("9",9);

        //replace characters, leave only lowwercase, numbers and spaces
        req = req.toLowerCase().replaceAll("[^a-z0-9\\s]+","");
        String[] arr = req.split(" ");

        System.out.println(req);

        ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();

        for(int i = 0; i < arr.length; i++){
            //look for food
            Item item = map.get(arr[i]);
            if (item != null){
                OrderItem oi = new OrderItem(item, 1, null);
                // number -> extra -> food
                // extra -> food //NUM
                // food -> extra

                //check before
                if (i > 0){
                    if ( extras.contains(arr[i-1]) ) {
                        oi.extra = arr[i-1];
                        if (i > 1 && nums.get(arr[i-2])!=null) oi.quantity = nums.get(arr[i-2]);
                    }
                    else if (nums.get(arr[i-1])!=null) oi.quantity = nums.get(arr[i-1]);
                }

                //check after
                if (i < arr.length - 1) {
                    //if ( oi.quantity == 1 && nums.get(arr[i+1])!=null) oi.quantity = nums.get(arr[i+1]);
                    if ( oi.extra == null && extras.contains(arr[i+1]) ) oi.extra = arr[i+1];
                }



                orderItems.add(oi);
            }
        }

        //print result
        for(OrderItem oi:orderItems)
            System.out.println(oi);

        System.out.println("---end---");

    }

    //TODO: REMOVE STATIC
    public static class OrderItem {
        public Item item;
        public String extra;
        public Integer quantity = 1;

        public OrderItem(Item item, Integer quantity, String extra){
            this.item = item;
            this.quantity = quantity;
            this.extra = extra;
        }

        public String toString(){
            return Integer.toString(quantity) + " " + item + " " + extra;
        }
    }

    //TODO: REMOVE STATIC
    public static class Item {
        public String name;
        public String[] aka;
        public String img;
        public String type;
        public double price;

        public Item(String name, String img, double price, String type, String[] aka){
            this.name = name;
            this.img = img;
            this.price = price;
            this.type = type;
            this.aka =  new String[aka.length + 1]; this.aka[0] = name; System.arraycopy(aka, 0, this.aka, 1, aka.length);
        }

        public String toString(){
            return Double.toString(price) + " " + name + " " + img;// + akas();
        }

        public String akas(){
            String s = "";
            for(String str : aka){
                s += str + ", ";
            }
            return s;
        }

    }


}
