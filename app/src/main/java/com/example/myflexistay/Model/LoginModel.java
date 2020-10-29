package com.example.myflexistay.Model;

public class LoginModel {

    private int country_id;

    private Integer username;

    private String password;

    public LoginModel(int country_id, Integer username, String password) {
        this.country_id = country_id;
        this.username = username;
        this.password = password;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public Integer getUsername() {
        return username;
    }

    public void setUsername(Integer username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
