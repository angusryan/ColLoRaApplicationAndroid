package com.example.nav;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import static com.example.nav.MapActivity.stateID;
import static com.example.nav.MapActivity.stateID1;
import static com.example.nav.MapActivity.stateID2;
import static com.example.nav.MapActivity.stateID3;
import static com.example.nav.MapActivity.stateID4;
import static com.example.nav.MapActivity.stateID5;
import static com.example.nav.MapActivity.stateID6;
import static com.example.nav.MapActivity.stateID7;
import static com.example.nav.MapActivity.stateID8;
import static com.example.nav.RecyclerAdapter.mark1;
import static com.example.nav.RecyclerAdapter.mark8;

public class Activity2 extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    int PrevState, PrevState1,PrevState2,PrevState3,PrevState4,
            PrevState5,PrevState6,PrevState7,PrevState8;

    //variables

   /* public static final String SHARED_PREFS = "sharedPrefs";*/
    /*public static final String TEXT = "text";
    public static final String SWITCH1 = "SWITCH1";
    double number;*/




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);



        final Intent myIntent = new Intent(Activity2.this, MapActivity.class);

       /* loadData();
        updateViews();*/


        try {
            PrevState = Integer.parseInt(stateID);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }
        try {
            PrevState1 = Integer.parseInt(stateID1);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }
        try {
            PrevState2 = Integer.parseInt(stateID2);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }
        try {
            PrevState3 = Integer.parseInt(stateID3);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }
        try {
            PrevState4 = Integer.parseInt(stateID4);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }
        try {
            PrevState5 = Integer.parseInt(stateID5);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }
        try {
            PrevState6 = Integer.parseInt(stateID6);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }
        try {
            PrevState7 = Integer.parseInt(stateID7);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }
        try {
            PrevState8 = Integer.parseInt(stateID8);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }




        //Bottom navigation bar on click settings and initializing
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_map:
                        startActivity(myIntent);

                        return true;
                    case R.id.menu_cow:
                        return true;
                    case R.id.menu_info:
                        Intent c = new Intent(Activity2.this, Information.class);
                        startActivity(c);
                        return true;
                }
                return false;
            }
        });
        recyclerView =
                (RecyclerView) findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
        new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        if(PrevState == 1) {
            recyclerView.findViewHolderForAdapterPosition(0).itemView.performClick();
        }
        if(PrevState1 == 1) {
            recyclerView.findViewHolderForAdapterPosition(1).itemView.performClick();
        }
        if(PrevState2 == 1) {
            recyclerView.findViewHolderForAdapterPosition(2).itemView.performClick();
        }
        if(PrevState3 == 1) {
            recyclerView.findViewHolderForAdapterPosition(3).itemView.performClick();
        }
        if(PrevState4 == 1) {
            recyclerView.findViewHolderForAdapterPosition(4).itemView.performClick();
        }
        if(PrevState5 == 1) {
            recyclerView.findViewHolderForAdapterPosition(5).itemView.performClick();
        }
        if(PrevState6 == 1) {
            recyclerView.findViewHolderForAdapterPosition(6).itemView.performClick();
        }
        if(PrevState7 == 1) {
            recyclerView.findViewHolderForAdapterPosition(7).itemView.performClick();
        }
        if(PrevState8 == 1) {
            recyclerView.findViewHolderForAdapterPosition(8).itemView.performClick();
        }

    }
    },1);
    }




    //METHODS TO SAVE DATA VARIABLES USING SHARED PREFERENCES
   /* public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(SWITCH1, switch1.isChecked()); //if not checked it is false
        editor.apply();

    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        switchOnOff = sharedPreferences.getBoolean(SWITCH1, false); // switch off by default

    }

    public void updateViews() {
        switch1.setChecked(switchOnOff);
    }*/

}


