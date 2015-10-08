
//package com.example.sagivo.myapplication;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Lang {
    public static void main(String[] args)
    {

        System.out.println("Hello, World!");

        String req = "Hello, can i please get one burger, 2 chicken sandwich and an apple pie?";

        String[] _ignore = new String[]{"hi", "hello", "how are you", "thank you", "can", "i", "a", "an", "get", "please", "and", "thanks", "bye" };
        Set<String> ignore= new HashSet<String>(Arrays.asList(_ignore));

        String[] _food = new String[]{ "Whopper", "burger", "cheeseburger", "chicken sandwich", "fish sandwich"};
        Set<String> food= new HashSet<String>(Arrays.asList(_ignore));

        String[] _dtinks = new String[]{"coke", "pepsi", "cola", "kola", "smoothie", "coffee", "sprite"};
        Set<String> dtinks= new HashSet<String>(Arrays.asList(_ignore));

        String[] _sides = new String[]{"coke", "pepsi", "cola", "kola", "smoothie", "coffee", "sprite"};
        Set<String> sides= new HashSet<String>(Arrays.asList(_ignore));

        String[] _salads = new String[]{"caesar salad"};
        Set<String> salads= new HashSet<String>(Arrays.asList(_ignore));

        String[] _desserts = new String[]{"apple pie", "sundae pie"};
        Set<String> desserts= new HashSet<String>(Arrays.asList(_ignore));

        Hashtable<String, Integer> nums = new Hashtable<String, Integer>();
        nums.put("one",1); nums.put("1",1); nums.put("single",1);
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
        arr = req.split("");

        System.out.println(arr);
        System.out.println("End!");
    }


}
