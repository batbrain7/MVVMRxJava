package com.example.mohitkumar.footballapp2;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

public class MainApplication extends MultiDexApplication {

    public static volatile Context context;
    public static final String TAG = "FootBallApplicationTAGS";

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
