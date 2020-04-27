package com.example.nav;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Information extends AppCompatActivity  {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_map:
                        Intent myIntent = new Intent(Information.this, MapActivity.class);
                        startActivity(myIntent);

                        return true;
                    case R.id.menu_cow:
                        Intent Intent2 = new Intent(Information.this, Activity2.class);
                        startActivity(Intent2);
                        return true;
                    case R.id.menu_info:
                        /*Intent c = new Intent(Information.this, Information.class);
                        startActivity(c);*/
                        return true;
                }
                return false;
            }
        });

    }



}
