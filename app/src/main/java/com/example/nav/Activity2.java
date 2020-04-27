package com.example.nav;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
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

import java.io.ByteArrayInputStream;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.net.URI;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.google.android.gms.common.api.Response;

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


import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.json.JSONObject;
import org.thethingsnetwork.data.common.Connection;
import org.thethingsnetwork.data.common.Metadata;
import org.thethingsnetwork.data.common.messages.ActivationMessage;
import org.thethingsnetwork.data.common.messages.DataMessage;
import org.thethingsnetwork.data.common.messages.DownlinkMessage;
import org.thethingsnetwork.data.common.messages.RawMessage;
import org.thethingsnetwork.data.common.messages.UplinkMessage;
import org.thethingsnetwork.data.mqtt.Client;
import org.thethingsnetwork.data.common.Metadata.Gateway;
import static com.example.nav.RegisterDialog.cowslist;




public class Activity2 extends AppCompatActivity {

    String TAG = "Activity2";
    Button addTracker;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    int PrevState, PrevState1,PrevState2,PrevState3,PrevState4,
            PrevState5,PrevState6,PrevState7,PrevState8;


    //MSG sent to TTN
    DownlinkMessage msg = new DownlinkMessage(1, "SGV5");


    //ttn connection variables
    public String region = "thethings.meshed.com.au:1904";
    public String appId = "collora";
    public String accessKey = "ttn-account-v2.RMgOKRg1mehaLyaMTEZ1zAMZIWVoP6NeLvbyEPYnP_8";

    public Client client;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        final Intent startMap = new Intent(Activity2.this, MapActivity.class);

       /* try {
            //base client to interact with The Things Network Handler
            client = new  Client(region, appId, accessKey );
            Log.d(TAG, "" +
                    "Initialise client");


             } catch (URISyntaxException e) {
           Log.d(TAG, "Client Initialisation failed");

            } catch (java.lang.Exception e){
            Log.d(TAG, "java lang fail");
            }*/

       /* client.onError((Throwable _error) -> System.err.println("error: " + _error.getMessage()));
        client.onConnected((Connection _client) -> System.out.println("connected !"));



        //Detects when message is posted on TTN and grabs the data
        client.onMessage("colloraapplicationstest3","gps_3.latitude",(String devId, DataMessage data) ->
        {
            try {
                System.out.println(1);
                RawMessage mess = (RawMessage) data;
                System.out.println(devId);
                System.out.println("longitude " + mess.asString());
            } catch (Exception ex) {
                System.out.println("response failed " + ex.getMessage());
            }

        });*/

        //Sends message to TTN on selected device
//      client.send("colloraapplicationsday2", msg);


        //Starts the client
/*        try {
            client.start();
        } catch (
                java.lang.InterruptedException e){
            Log.d(TAG, "end failed");

        } catch (org.eclipse.paho.client.mqttv3.MqttException e){
            Log.d(TAG, "end failed 2");

        } catch (java.lang.Exception e) {
            Log.d(TAG, "java lang fail5");

        }*/

        addTracker = findViewById(R.id.addTracker);
        addTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });





        //Bottom navigation bar on click settings and initializing
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_map:
                        startActivity(startMap);

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

    public void openDialog(){
        RegisterDialog registerDialog = new RegisterDialog();
        registerDialog.show(getSupportFragmentManager(), "register dialog");
    }

}


