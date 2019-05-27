package com.example.user.siba;

import java.io.Serializable;

public class UserFlight implements Serializable{
    private String date;
    private String number;
    private String time;
    private String des;
    private long timems;
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

    public long getTimems() {
        return timems;
    }

    public void setTimems(long timems) {
        this.timems = timems;
    }

    @Override
    public String toString() {
        return
                "date='" + date + '\'' +
                ",       Flight No=  '" + number + '\'' +
                ",       time='" + time + '\'' +
                ",       destination='" + des + '\'' +""
                +" time ms: "+timems;
    }
}
