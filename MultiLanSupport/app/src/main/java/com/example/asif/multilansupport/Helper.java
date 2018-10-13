package com.example.asif.multilansupport;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;

public class Helper {

    public static void setLocale(String lan, Context context){
        Locale locale = new Locale(lan);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;

        context.getResources().updateConfiguration(config,context.getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = context.getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_lan",lan);
        editor.apply();

    }

    public static void loadLocale(Context context){
        SharedPreferences sp = context.getSharedPreferences("Settings", MODE_PRIVATE);
        String language= sp.getString("My_lan","");
        setLocale(language,context);
    }

}
