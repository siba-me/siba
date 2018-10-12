package com.example.user.siba;

public class Item {

    private int imageView;
    private String name;

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item(int imageView, String name) {

        this.imageView = imageView;
        this.name = name;
    }
}
