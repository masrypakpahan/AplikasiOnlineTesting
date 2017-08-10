package com.pji.cbt.aplikasionlinetesting.data.beans;

import android.widget.EditText;

/**
 * Created by Masry Pakpahan on 19/07/2017.
 */

public class UpdateUser_model {
    public int id;
    public String name;
    public String email;

    public UpdateUser_model(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
