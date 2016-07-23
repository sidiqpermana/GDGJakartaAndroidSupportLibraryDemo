package com.nbs.gdgjakartaandroidsupportlibrarydemo;

import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by Sidiq on 23/07/2016.
 */
public class App extends MultiDexApplication {
    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }
}
