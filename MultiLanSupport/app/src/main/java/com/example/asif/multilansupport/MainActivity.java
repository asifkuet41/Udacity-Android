package com.example.asif.multilansupport;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.example.asif.multilansupport.Helper.loadLocale;

public class MainActivity extends AppCompatActivity {


    MapView map;
    int value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        map = (MapView) findViewById(R.id.map);
//        map.setTileSource(TileSourceFactory.MAPNIK);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLanguageDialog();
            }
        });

    }

    private void showChangeLanguageDialog(){

        final String[]items = {"Bangla","Hindi","English"};



        List<Integer>mSelectedItems = new ArrayList<>();
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Select your language");
        mBuilder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
             value = which;
            }
        }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"value"+value,Toast.LENGTH_SHORT).show();
                recreate();
            }
        });


//        mBuilder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                if(which == 0){
//                    Helper.setLocale("bn",MainActivity.this);
//                    recreate();
//                }
//
//                else if(which == 1){
//                    Helper.setLocale("hi",MainActivity.this);
//                    recreate();
//                }
//                else{
//                    Helper.setLocale("en",MainActivity.this);
//                    recreate();
//                }
//
//                dialog.dismiss();
//            }
//        });
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }


}
