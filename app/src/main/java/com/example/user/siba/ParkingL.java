package com.example.user.siba;

public class ParkingL {


    private String image;
    private String information;

    @Override
    public String toString() {
        return "parkingL{" +
                "image=" + image +
                ", information='" + information + '\'' +
                '}';
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getImage() {

        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ParkingL(String image, String information) {

        this.image = image;
        this.information = information;
    }

}
