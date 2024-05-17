package com.example.task3;

import android.widget.Button;

public class RecyclerItemRank {

    private String itemrankno;
    private int imageResource;
    private String name;
    private String mail;
    private String point;


    public RecyclerItemRank(String itemrankno, int imageResource, String name, String mail, String point) {
        this.itemrankno = itemrankno;
        this.imageResource = imageResource;
        this.name = name;
        this.mail = mail;
        this.point = point;
    }

    public String getItemrankno() {
        return itemrankno;
    }

    public void setItemrankno(String itemrankno) {
        this.itemrankno = itemrankno;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }


}
