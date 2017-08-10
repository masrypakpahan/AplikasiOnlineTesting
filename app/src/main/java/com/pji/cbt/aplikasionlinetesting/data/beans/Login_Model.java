package com.pji.cbt.aplikasionlinetesting.data.beans;

/**
 * Created by Masry Pakpahan on 17/07/2017.
 */

public class Login_Model {

    public int Id;
    public String username;
    public String password;

    public Login_Model( int Id,String username, String password ) {
        this.Id =Id;
        this.username = username;
        this.password = password;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
