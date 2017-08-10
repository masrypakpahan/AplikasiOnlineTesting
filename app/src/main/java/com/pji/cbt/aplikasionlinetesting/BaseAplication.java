package com.pji.cbt.aplikasionlinetesting;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.pji.cbt.aplikasionlinetesting.network.RestUser;
import com.pji.cbt.aplikasionlinetesting.network.API;

/**
 * Created by Masry Pakpahan on 25/07/2017.
 */

public class BaseAplication extends Application {
    private static BaseAplication currentApplication;

    private SharedPreferences appSharedPreferences;
    private SharedPreferences ncAppSharedPreferences;
    //private ObjectGraph objectGraph;
    private RestUser mrestUser;

    public BaseAplication()
    {
        currentApplication = this;
    }

    public static synchronized BaseAplication getInstance(){return currentApplication;}
//
//    public static BaseApplication from(Activity activity)
//    {
//        return (BaseApplication) activity.getApplication();
//    }


    @Override
    public void onCreate() {
        super.onCreate();
        setupAppSharedPreferences();
        currentApplication=this;
//        Object prodModule = new BaseModule(this);
//        objectGraph = ObjectGraph.create(prodModule);
//
//        LibraryCrash.install(this);
//        ACRA.init(this);
//        ACRAReportSender reportSender = new ACRAReportSender(getBaseContext(), "pactera.report@gmail.com", "binimuda14");
//        ACRA.getErrorReporter().setReportSender(reportSender);

    }

    private void setupAppSharedPreferences(){
        this.appSharedPreferences = getSharedPreferences(BaseAplication.class.getSimpleName(), Context.MODE_PRIVATE);
        this.ncAppSharedPreferences = getSharedPreferences("nc"+BaseAplication.class.getSimpleName(), Context.MODE_PRIVATE);

    }
    public SharedPreferences getAppSharedPreferences(){
        return appSharedPreferences;
    }

    public SharedPreferences getncAppSharedPreferences(){
        return ncAppSharedPreferences;
    }



//    public ObjectGraph objectGraph() {
//        return objectGraph;
//    }
//
//    public void inject(Object o) {
//        objectGraph.inject(o);
//    }

    public static BaseAplication get(Context context)
    {
        return (BaseAplication) context.getApplicationContext();
    }

    public RestUser getRestUser(){

        if(mrestUser == null){
            mrestUser = new RestUser();
        }
        return mrestUser;
    }


    public API getFirstApi(){
        return getRestUser().getRestUser();
    }

//    public SecondNetworkService getSecondNetworkService(){
//        if(mSecondService == null){
//            mSecondService = new SecondNetworkService();
//        }
//        return mSecondService;
//    }
//
//    public SecondNetworkAPI getSecondApi(){
//        return getSecondNetworkService().getApi();
//    }
}
