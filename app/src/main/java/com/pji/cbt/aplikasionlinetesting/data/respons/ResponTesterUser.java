package com.pji.cbt.aplikasionlinetesting.data.respons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pji.cbt.aplikasionlinetesting.data.beans.Testuser;

import java.util.List;

/**
 * Created by Masry Pakpahan on 01/08/2017.
 */

public class ResponTesterUser {
    @SerializedName("Testuser")
    @Expose
    private List<Testuser> testuser = null;

    public List<Testuser> getTestuser() {
        return testuser;
    }

    public void setTestuser(List<Testuser> testuser) {
        this.testuser = testuser;
    }

}
