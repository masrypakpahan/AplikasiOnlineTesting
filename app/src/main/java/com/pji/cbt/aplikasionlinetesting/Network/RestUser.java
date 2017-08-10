package com.pji.cbt.aplikasionlinetesting.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Masry Pakpahan on 17/07/2017.
 */

public class RestUser {
    private static API REST_USER;

    public static String URL = "http://10.13.1.116:9091/";

    static {
        setRestClient();
    }

    public RestUser() {
    }

    public static API getRestUser() {
        return REST_USER;
    }

    private static void setRestClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        REST_USER = retrofit.create(API.class);
    }
}

