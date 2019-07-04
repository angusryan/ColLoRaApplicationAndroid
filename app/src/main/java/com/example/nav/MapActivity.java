package com.example.nav;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import static com.example.nav.RecyclerAdapter.mark1;
import static com.example.nav.RecyclerAdapter.mark2;
import static com.example.nav.RecyclerAdapter.mark3;
import static com.example.nav.RecyclerAdapter.mark4;
import static com.example.nav.RecyclerAdapter.mark5;
import static com.example.nav.RecyclerAdapter.mark6;
import static com.example.nav.RecyclerAdapter.mark7;
import static com.example.nav.RecyclerAdapter.mark8;
import static com.example.nav.RecyclerAdapter.mark9;

/*import org.thethingsnetwork.data.mqtt.Client;*/

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {


    public static String stateID  = "IDSTATE";
    public static String stateID1 = "IDSTATE";
    public static String stateID2 = "IDSTATE";
    public static String stateID3 = "IDSTATE";
    public static String stateID4 = "IDSTATE";
    public static String stateID5 = "IDSTATE";
    public static String stateID6 = "IDSTATE";
    public static String stateID7 = "IDSTATE";
    public static String stateID8 = "IDSTATE";






    //credentials to connect
   /* private static final String APP_EUI = "asdasd";
    private static final String ACCESS_KEY = "asdds";
    private static final String STAGING_HOST = "staging.thethingsnetwork.org";
*/
    /*TTNMqttClient mTTNMqttClient;*/

    //variables
    private Boolean mLocationPermissionGranted = false;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    ListView listView;
    private static final float DEFAULT_ZOOM = 15f;

    String region = "meshed-handler";
    String appId = "colloraapplication";
    String accessKey = "default key";

    int adapterNum,adapterNum1,adapterNum2,adapterNum3,
        adapterNum4, adapterNum5,adapterNum6,adapterNum7, adapterNum8;
    private static final String TAG = "MapActivity";
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;





    /*Client client;

    {
        try {
            client = new Client(region, appId, accessKey);
            Log.d(TAG, "client initiate");
            client.start();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "client initiate2");


        }
    }*/

    private void activation() {
        //client.onActivation((String_devid , JSONObject ) -> System.out.println("Message"));
        //client.onMessage((String devId, Object data) -> System.out.println("Message: " + devId + " " + data));
    }




   /* public interface MqttApiListener {
        void OnPacket(Packet packet);

        void OnError(Throwable throwable);

        void onConnected();

        void onDisconnected();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onstart thing");
        subscribe();
    }

    @Override
    public void onStop() {
        super.onStop();

        mTTNMqttClient.disconnect();
    }

    void subscribe() {

        // instantiate a new client
        mTTNMqttClient = new TTNMqttClient(STAGING_HOST, APP_EUI, ACCESS_KEY, "+");

        //subscribe for new packets
        mTTNMqttClient.listen(new org.ttn.android.sdk.v1.client.MqttApiListener() {
            @Override
            public void onPacket(Packet packet) {
                //notify user
                Log.d(TAG, "onPacket");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onConnected() {

            }

            @Override
            public void onDisconnected() {

            }
        });


    }*/

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG, "onMapReady: ready");
        mMap = googleMap;

        if (mLocationPermissionGranted) {
            getDeviceLocation();
            Log.d(TAG, "deviceLocation");
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            mMap.setMyLocationEnabled(true);

        }
        CameraUpdate point = CameraUpdateFactory.newLatLng(new LatLng(-33, 141));
        try {
            adapterNum  = Integer.parseInt(mark1);

        } catch(NumberFormatException nfe) {
            // Handle parse error.
            Log.d("try", "parseIntfailed");

        }
        try {
            adapterNum1 = Integer.parseInt(mark2);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }
        try {
            adapterNum2 = Integer.parseInt(mark3);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }
        try {
            adapterNum3 = Integer.parseInt(mark4);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }
        try {
            adapterNum4 = Integer.parseInt(mark5);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }
        try {
            adapterNum5 = Integer.parseInt(mark6);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }
        try {
            adapterNum6 = Integer.parseInt(mark7);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }
        try {
            adapterNum7 = Integer.parseInt(mark8);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }
        try {
            adapterNum8 = Integer.parseInt(mark9);
        } catch(NumberFormatException nfe) {
            // Handle parse error.
        }
        /*Marker singleMarker;
        singleMarker = mMap.addMarker(location1)*/
        // moves camera to coordinates
        mMap.moveCamera(point);
        LatLng location1 = new LatLng(-32.870575, 148.204755);

        LatLng location2 = new LatLng(-33.870575, 149.204755);

        LatLng location3 = new LatLng(-34.321542, 150.123412);

        LatLng location4 = new LatLng(-35.370575, 148.204755);

        LatLng location5 = new LatLng(-34.654575, 149.204755);

        LatLng location6 = new LatLng(-34.870575, 148.104755);

        LatLng location7 = new LatLng(-33.870575, 147.204755);

        LatLng location8 = new LatLng(-36.870575, 149.204755);

        Intent a = getIntent();
        double data1 = a.getDoubleExtra("number", 0 );
        if(adapterNum == 1){
            mMap.addMarker(new MarkerOptions().snippet("Latitude:-32.870575 Longitude:148.204755").position(location1).title("ColLoRa ID: 11823")
                    .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cow", 40,
                            40))));
            /*MarkerOptions hello = new MarkerOptions().position(location1);
            Marker marker = mMap.addMarker(hello);*/
            stateID8 = "1";
        } else if (adapterNum == 0){
            Log.d("marker tag", "empty else if");
            stateID8= "0";
        }

        if(adapterNum1 == 1){
            Log.d("m arker tag", "adapternum1");


            mMap.addMarker(new MarkerOptions().snippet("Latitude:-33.870575 Longitude:149.204755").position(location2).title("ColLoRa ID: 65463")
                    .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cow", 40,
                            40))));
            stateID1 = "1";
        } else if (adapterNum1 == 0){
            Log.d("marker tag", "empty else if");
            stateID1 = "0";


        }

        if(adapterNum2 == 1){
            mMap.addMarker(new MarkerOptions().snippet("Latitude:-34.321542 Longitude:150.123412")
                    .position(location3).title("ColLoRa ID: 34553")
                    .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cow", 40,
                            40))));
            stateID2 = "1";
        } else if (adapterNum2 == 0){
            Log.d("marker tag", "empty else if");
            stateID2 = "0";

        }

        if(adapterNum3 == 1){
            mMap.addMarker(new MarkerOptions().snippet("Latitude:-35.370575 Longitude:148.204755").position(location4).title("ColLoRa ID: 23452")
                    .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cow", 40,
                            40))));
            stateID3 = "1";
        } else if (adapterNum3 == 0){
            Log.d("marker tag", "empty else if");
            stateID3 = "0";

        }

        if(adapterNum4 == 1){
            mMap.addMarker(new MarkerOptions().snippet("Latitude:-34.654575 Longitude:149.204755")
                    .position(location5).title("ColLoRa ID: 76453")
                    .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cow", 40,
                            40))));
            stateID4 = "1";
        } else if (adapterNum4 == 0){
            Log.d("marker tag", "empty else if");
            stateID4 = "0";

        }

        if(adapterNum5 == 1){
            mMap.addMarker(new MarkerOptions().snippet("Latitude:-34.870575 Longitude:148.104755").position(location6).title("ColLoRa ID: 23412")
                    .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cow", 40,
                            40))));
            stateID5 = "1";
        } else if (adapterNum5 == 0){
            Log.d("marker tag", "empty else if");
            stateID5 = "0";

        }

        if(adapterNum6 == 1){
            mMap.addMarker(new MarkerOptions().snippet("Latitude:-33.870575 Longitude:147.204755").position(location7).title("ColLoRa ID: 72151")
                    .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cow", 40,
                            40))));
            stateID6 = "1";
        } else if (adapterNum6 == 0){
            Log.d("marker tag", "empty else if");
            stateID6 = "0";

        }

        if(adapterNum7 == 1 ){
            mMap.addMarker(new MarkerOptions().snippet("Latitude:-36.870575 Longitude:149.204755")
                    .position(location8).title("ColLoRa ID: 52151")
                    .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cow", 40,
                            40))));
            stateID7 = "1";
        } else if (adapterNum7 == 0){
            Log.d("marker tag", "empty else if");
            stateID7 = "0";
        }

        if(adapterNum8 == 1){
            mMap.addMarker(new MarkerOptions().snippet("Latitude:-32.870575 Longitude:148.204755").position(location1).title("ColLoRa ID: 11823")
                    .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cow", 40,
                            40))));
            mMap.addMarker(new MarkerOptions().snippet("Latitude:-33.870575 Longitude:149.204755").position(location2).title("ColLoRa ID: 65463")
                    .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cow", 40,
                            40))));
            mMap.addMarker(new MarkerOptions().snippet("Latitude:-34.321542 Longitude:150.123412").position(location3).title("ColLoRa ID: 34553")
                    .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cow", 40,
                            40))));
            mMap.addMarker(new MarkerOptions().snippet("Latitude:-35.370575 Longitude:148.204755").position(location4).title("ColLoRa ID: 23452")
                    .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cow", 40,
                            40))));
            mMap.addMarker(new MarkerOptions().snippet("Latitude:-34.654575 Longitude:149.204755").position(location5).title("ColLoRa ID: 76453")
                    .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cow", 40,
                            40))));
            mMap.addMarker(new MarkerOptions().snippet("Latitude:-34.870575 Longitude:148.104755").position(location6).title( "ColLoRa ID: 23412")
                    .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cow", 40,
                            40))));
            mMap.addMarker(new MarkerOptions().snippet("Latitude:-33.870575 Longitude:147.204755").position(location7).title("ColLoRa ID: 72151")
                    .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cow", 40,
                            40))));
            mMap.addMarker(new MarkerOptions().snippet("Latitude:-36.870575 Longitude:149.204755").position(location8).title("ColLoRa ID: 52151")
                    .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cow", 40,
                            40))));
            stateID = "1";
        } else if (adapterNum8 == 0){
            Log.d("marker tag", "empty else if");
            stateID = "0";

        }



    }













    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_map:
                        return true;
                    case R.id.menu_cow:
                        Intent b = new Intent(MapActivity.this, Activity2.class);
                        startActivity(b);
                        return true;
                    case R.id.menu_info:
                        Intent c = new Intent(MapActivity.this, Information.class);
                        startActivity(c);
                        return true;
                }

                return false;

            }
        });
        getLocationPermission();
        /*mark2();*/

    }

    private void getDeviceLocation() {
        Log.d(TAG, "device location");

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try{
            if (mLocationPermissionGranted){
                final Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "onComplete:found location");
                            Location currentLocation = (Location) task.getResult();

                           /* moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
                              DEFAULT_ZOOM);*/

                        }else{
                            Log.d(TAG, "onComplete:location NULL");
                        }
                    }
                });
            }

        }catch (SecurityException e){
            Log.e(TAG, "getDeviceLocation: SecurityException: " + e.getMessage() );
        }

    }

    private void moveCamera(LatLng latlng, float zoom){
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, zoom));
    }







    private void initMap(){
        Log.d(TAG, "init map: initializing map");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);


        mapFragment.getMapAsync(MapActivity.this);
    }

    private void getLocationPermission(){
        Log.d(TAG, "getting location permissions");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                mLocationPermissionGranted = true;
                initMap();
            }else{
                ActivityCompat.requestPermissions(this,
                        permissions,
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
        }else{
            ActivityCompat.requestPermissions(this,
                    permissions,
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Log.d(TAG,"menu select");
        switch (item.getItemId()) {
            case R.id.Hybrid:

                mMap.setMapType(mMap.MAP_TYPE_HYBRID);


                return true;

            case R.id.Normal:

                mMap.setMapType(mMap.MAP_TYPE_NORMAL);
               /* LatLng somewhere2 = new LatLng(213, 151.204755);
                mMap.addMarker(new MarkerOptions().position(somewhere2).alpha(1f).title("marker in somewhere")
                        .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("coow",
                                70, 70))).snippet("Lat:-36.870575 Lng:151.204755"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(somewhere2));
                Intent a = new Intent(MapActivity.this, MapActivity.class);
                startActivity(a);*/
                //mMap.moveCamera(CameraUpdateFactory.newLatLng(somewhere2));


                return true;

            case R.id.Terrain:
                mMap.setMapType(mMap.MAP_TYPE_TERRAIN);

                return true;

            case R.id.Satellite:
                mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        mLocationPermissionGranted = false;

        switch(requestCode){
            case LOCATION_PERMISSION_REQUEST_CODE:{
                if(grantResults.length> 0) {
                    for (int i = 0; i < grantResults.length; i++) {
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                        mLocationPermissionGranted = false;
                        return;
                    }
                }
                    mLocationPermissionGranted = true;
                    //initilize map
                    initMap();
                }
            }
        }
    }

    //class to resize marker and change marker image
    public Bitmap resizeMapIcons(String iconName,int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources()
                .getIdentifier(iconName, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }
}