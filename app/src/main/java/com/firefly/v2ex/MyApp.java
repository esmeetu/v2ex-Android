package com.firefly.v2ex;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by jason on 9/16/17.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences sharedPreferences = getSharedPreferences("name", MODE_PRIVATE);
        sharedPreferences.edit().putString("123", "123").commit();
    }
}
