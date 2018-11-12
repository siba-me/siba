package com.example.user.siba;

public class UserFlight {
    private String date;
    private String number;
    private String time;
    private String des;

    public UserFlight(String date, String number, String time, String des) {

        this.date = date;
        this.number = number;
        this.time = time;
        this.des = des;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDes(String des) {
        this.des = des;
    }


    public String getDate() {
        return date;
    }

    public String  getNumber() {
        return number;
    }

    public String getTime() {
        return time;
    }

    public String getDes() {
        return des;
    }


}
