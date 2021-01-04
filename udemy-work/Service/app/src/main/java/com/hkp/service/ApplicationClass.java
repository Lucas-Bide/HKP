package com.hkp.service;

import android.app.Application;
import android.content.Context;

public class ApplicationClass extends Application {

    public static Context context;

    public ApplicationClass() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
