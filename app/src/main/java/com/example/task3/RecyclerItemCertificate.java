package com.example.task3;

public class RecyclerItemCertificate {

    private String itemCertificateNo;
    private String itemCertificateTitle;
    private int imageResource;
    private String itemDescription;
    private String point;

    public RecyclerItemCertificate(String itemCertificateNo, String itemCertificateTitle, int imageResource, String itemDescription, String point) {
        this.itemCertificateNo = itemCertificateNo;
        this.itemCertificateTitle = itemCertificateTitle;
        this.imageResource = imageResource;
        this.itemDescription = itemDescription;
        this.point = point;
    }

    public String getItemCertificateNo() {
        return itemCertificateNo;
    }

    public void setItemCertificateNo(String itemCertificateNo) {
        this.itemCertificateNo = itemCertificateNo;
    }

    public String getItemCertificateTitle() {
        return itemCertificateTitle;
    }

    public void setItemCertificateTitle(String itemCertificateTitle) {
        this.itemCertificateTitle = itemCertificateTitle;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
