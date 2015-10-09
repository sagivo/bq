package com.example.sagivo.myapplication;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author Yalantis
 */
public class Friend {
    private int avatar;
    private String nickname;
    private int background;
    private List<String> interests = new ArrayList<>();

    public Friend(int avatar, String nickname, int background, String... interest) {
        this.avatar = avatar;
        this.nickname = nickname;
        this.background = background;
        interests.addAll(Arrays.asList(interest));
    }

    public int getAvatar() {
        return avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public int getBackground() {
        return background;
    }

    public List<String> getInterests() {
        return interests;
    }

    public static List<Friend> getAll(Integer tab){
        List<Friend> friends = new ArrayList<Friend>();
        if (tab == 0) {
            friends.add(new Friend(R.drawable.b1, "WHOPPER", R.color.sienna, "$6.99", "1400 calories", "Spicy", "Cat Meet", "Not That Good"));
            friends.add(new Friend(R.drawable.b2, "Fried Chicken", R.color.pink, "$6.99", "1400 calories", "Spicy", "Cat Meet", "Yummy"));
            friends.add(new Friend(R.drawable.b3, "KATE", R.color.green, "Sales", "Pets", "Skiing", "Hairstyles", "Сoffee"));
            friends.add(new Friend(R.drawable.b4, "Fried Chicken", R.color.pink, "$6.99", "1400 calories", "Spicy", "Cat Meet", "Yummy"));
            friends.add(new Friend(R.drawable.b5, "DARIA", R.color.orange, "Design", "Fitness", "Healthcare", "UI/UX", "Chatting"));
            friends.add(new Friend(R.drawable.b6, "KIRILL", R.color.saffron, "Development", "Android", "Healthcare", "Sport", "Rock Music"));
            friends.add(new Friend(R.drawable.b7, "JULIA", R.color.green, "Cinema", "Music", "Tatoo", "Animals", "Management"));
            friends.add(new Friend(R.drawable.b2, "YALANTIS", R.color.purple, "Android", "IOS", "Application", "Development", "Company"));
        } else{
            friends.add(new Friend(R.drawable.d1, "WHOPPER", R.color.sienna, "$6.99", "1400 calories", "Spicy", "Cat Meet", "Not That Good"));
            friends.add(new Friend(R.drawable.d2, "IRENE", R.color.saffron, "Travelling", "Flights", "Books", "Painting", "Design"));
            friends.add(new Friend(R.drawable.d3, "KATE", R.color.green, "Sales", "Pets", "Skiing", "Hairstyles", "Сoffee"));
            friends.add(new Friend(R.drawable.d4, "Orange Jouice", R.color.pink, "$2.39", "10 calories", "Cold", "Cool", "Healthy(?)"));
            friends.add(new Friend(R.drawable.d5, "DARIA", R.color.orange, "Design", "Fitness", "Healthcare", "UI/UX", "Chatting"));
            friends.add(new Friend(R.drawable.d6, "KIRILL", R.color.saffron, "Development", "Android", "Healthcare", "Sport", "Rock Music"));
        }
        return friends;
    }
}
