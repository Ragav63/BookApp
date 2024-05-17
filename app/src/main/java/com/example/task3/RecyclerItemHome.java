package com.example.task3;

public class RecyclerItemHome {


    //Recycler items for Category recycler in Home fragment also for Category fragment
    private int imageResource;
    private String title;
    private String description;
    private String price;
    private float rating;

    public RecyclerItemHome( int imageResource, String title, String description, String price, float rating) {

        this.imageResource = imageResource;
        this.title = title;
        this.description = description;
        this.price = price;
        this.rating = rating;
    }


    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public float getRating() {
        return rating;
    }
}
