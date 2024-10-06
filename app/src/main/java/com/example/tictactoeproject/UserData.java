package com.example.tictactoeproject;

public class UserData {

    private String email;
    private String UserName;
    private int year;

    private int Xwins;
    private int Owins;


    public UserData(String email, String UserName, int year){
        this.email = email;
        this.UserName = UserName;
        this.year = year;
        Xwins = 0;
        Owins = 0;
    }
    public UserData(){

    }

    public String getEmail(){
        return email;
    }
    public String getUserName() {
        return UserName;
    }

    public int getYear() {
        return year;
    }

    public int getXwins(){
        return Xwins;
    }
    public int getOwins() {
        return Owins;
    }

}
