package com.example.nav;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.Map;

public class launch extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final int ERROR_DIALOG_REQUEST = 9001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__launch);


        if(isServicesOK()){
            innit();
        }
    }

    private void innit() {
        Button btnMap = (Button) findViewById(R.id.button);
        btnMap.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(launch.this, MapActivity.class);
                startActivity(intent);
            }
        }));


    }

    //Method for checking version

    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(launch.this);

        if(available == ConnectionResult.SUCCESS){
            //Everything is fine user can make map requests
            Log.d(TAG, "isServiceOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            //an error occured but we can resolve
            Log.d(TAG, "isServicesOK: an error occured but we can fix");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(launch.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else {
            Toast.makeText(this, "Cant make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}

