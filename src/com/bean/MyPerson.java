package com.bean;

import com.DateFormater;

import java.util.Date;

public class MyPerson {
    private int id;
    private String name;
    private String password;
    private String no;
    private String date;
    private String img;
    private String mac;

    public MyPerson(){
        super();
    }
    public MyPerson(String userName,String passWord,String no,String birthDay,String img){
        this.name = userName;
        this.date = birthDay;
        this.password = passWord;
        this.no = no;
        this.img = img;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "id ="+id+" name ="+name+" password ="+password+" no ="+no+" date ="+date;
    }
}
