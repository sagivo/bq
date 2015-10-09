package com.example.sagivo.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class VoiceOrderFragment extends Fragment {

    private static final int SPEECH_REQUEST_CODE = 10;
    TextView text_view;
    FloatingActionMenu actionMenu;
    View v;
    Button payBtn;

    public void generateList( String req ){
        ArrayList<OrderItem> orderItems = getItems(req);
        VoiceOrderAdapter adapter = new VoiceOrderAdapter(getActivity(), orderItems);
        ListView list = (ListView)v.findViewById(R.id.voice_order_list_view);
        list.setAdapter(adapter);
        double total = 0;
        for(OrderItem oi:orderItems)
            total += oi.item.price;

        if (orderItems.size() > 0){
            payBtn.setText("$" + Double.toString(total) + " PAY");
            payBtn.setVisibility(View.VISIBLE);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_voice_order ,container,false);

        text_view = (TextView)v.findViewById(R.id.voice_result);

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this.getActivity());
        // repeat many times:
        ImageView itemIcon = new ImageView(this.getActivity());
        itemIcon.setImageDrawable(getResources().getDrawable(R.drawable.cam));
        SubActionButton button1 = itemBuilder.setContentView(itemIcon).build();

        ImageView itemIcon2 = new ImageView(this.getActivity());
        itemIcon2.setImageDrawable(getResources().getDrawable(R.drawable.voice));
        SubActionButton button2 = itemBuilder.setContentView(itemIcon2).build();
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getReq();
            }
        });
        ImageView itemIcon3 = new ImageView(this.getActivity());
        itemIcon3.setImageDrawable(getResources().getDrawable(R.drawable.email));
        SubActionButton button3 = itemBuilder.setContentView(itemIcon3).build();


        actionMenu = new FloatingActionMenu.Builder(this.getActivity())
                .addSubActionView(button1)
                .addSubActionView(button3)
                .addSubActionView(button2)
                .attachTo(v.findViewById(R.id.action_fab)).build();


        payBtn = (Button)v.findViewById(R.id.voice_order_pay);
        payBtn.setVisibility(View.INVISIBLE);

        //generateList("Hi, can i get one hamburger, 2 chicken sandwich, 3 spicy fries, a wrap and cold cola?");

        return v;
    }

    // This callback is invoked when the Speech Recognizer returns.
    // This is where you process the intent and extract the speech text from the intent.
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        actionMenu.close(true);

        if (requestCode == SPEECH_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            generateList(spokenText);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    void getReq(){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Place Your Order...");
        intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, "4000");
        // Start the activity, the intent will be populated with the speech text
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }

    class VoiceOrderAdapter extends ArrayAdapter<OrderItem> {

        ArrayList<OrderItem> orderItems;

        public VoiceOrderAdapter(Context context, ArrayList<OrderItem> orderItems) {
            super(context, R.layout.voice_order_item ,orderItems);
            this.orderItems = orderItems;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater i = LayoutInflater.from(getContext());
            View row = i.inflate(R.layout.voice_order_item, parent, false);

            OrderItem oi = orderItems.get(position);
            ImageView pic = (ImageView) row.findViewById(R.id.voice_order_image);
            pic.setImageResource(row.getResources().getIdentifier(oi.item.img, "drawable", "com.example.sagivo.myapplication"));
            TextView title = (TextView) row.findViewById(R.id.voice_order_name);
            title.setText(oi.item.name.toUpperCase());
            TextView quantity = (TextView) row.findViewById(R.id.voice_order_quantity);
            quantity.setText(Double.toString(oi.quantity));
            Random rnd = new Random();
            title.setBackground(new ColorDrawable(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))));

            Animation myFadeInAnimation = AnimationUtils.loadAnimation(row.getContext(), R.anim.image_alpha);
            pic.startAnimation(myFadeInAnimation);

            return row;
        }

        @Override
        public int getViewTypeCount() {
            // menu type count
            return orderItems.size();
        }

        @Override
        public int getItemViewType(int position) {
            // current menu type
            return position;
        }
    }

    //---------------LANG

    public static ArrayList<OrderItem> getItems(String req)
    {
        //String req = "Hello, can i please get a spicy burger, 2 chicken sandwich and 2 coke cold?";

        ArrayList<OrderItem> orders = new ArrayList<OrderItem>();

        String[] _ignore = new String[]{"hi", "hello", "how are you", "thank you", "can", "i", "a", "an", "get", "please", "and", "thanks", "bye" };
        HashSet<String> ignore= new HashSet<String>(Arrays.asList(_ignore));

        String[] _extra = new String[]{ "spicy", "hot", "cold", "neat", "neet" };
        ArrayList<String> extras= new ArrayList<String>(Arrays.asList(_extra));

        Item[] foodItems = {
                new Item("burger", "b6", 5.99, "b", new String[]{"beef burger", "hamburger", "whopper", "burgers"}),
                new Item("chicken sandwich", "b2", 4.99, "b", new String[]{"chicken burger", "chicken"}),
                new Item("wrap", "wrap", 4.50, "b", new String[]{"burrito"}),

                new Item("coke", "d6", 2.99, "d", new String[]{"cola", "coka cola", "coce", "pepsi"}),
                new Item("sprite", "d6", 3.99, "d", new String[]{}),

                new Item("fries", "f1", 1.99, "s", new String[]{"fries"}),
                new Item("apple pie", "apple_pie", 2.99, "s", new String[]{"pie"}),
                new Item("cheese cake", "cookies", 6.99, "s", new String[]{"cheesecake"})
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

        return orderItems;
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