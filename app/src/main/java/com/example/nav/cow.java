package com.example.nav;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v7.app.AppCompatActivity;




public class cow extends AppCompatActivity{
    int id;
    LatLng location;
    GoogleMap mark;

    int stringPos = 0;
    String[] save = new String[stringPos];


    //Constructor for the cattle
    public cow(int id, LatLng location){
        this.id = id;
        this.location = location;

    }

    //Add marker to the map using the id
    public void move(int id){
        this.id = id;
        mark.addMarker(new MarkerOptions().snippet("Latitude " + String.valueOf(location.latitude) + "Longitude " + String.valueOf(location.longitude))
                .position(location).title(String.valueOf(id)));
//                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cow", 40,
//                        40))));

    }

    //Resize the size of the marker icon
//    public Bitmap resizeMapIcons(String iconName, int width, int height){
//        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources()
//                .getIdentifier(iconName, "drawable", getPackageName()));
//        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
//        return resizedBitmap;
//    }

    //Stores the cattle to a string array
    public String[] store(cow cow){
        this.id = cow.id;
        save[stringPos] = String.valueOf(location.latitude) + String.valueOf(location.longitude);
        stringPos++;
        return save;
    }
}
