package com.fantasycup.core.services;

public class People {
    private String username;
    private String email;

    public People(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public People() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
