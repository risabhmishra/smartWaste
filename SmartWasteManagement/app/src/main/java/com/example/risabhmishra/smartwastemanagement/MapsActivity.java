package com.example.risabhmishra.smartwastemanagement;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng University = new LatLng(12.823061, 80.043796);
    LatLng Ub = new LatLng(12.823408, 80.042400);
    LatLng TechPark = new LatLng(12.824893, 80.045307);
    LatLng Esb = new LatLng(12.819950, 80.039226);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Marker m1 = googleMap.addMarker(new MarkerOptions()
                .position(University)
                .anchor(0.5f, 0.5f)
                .title("University")
                .snippet("Snippet1")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_green)));

        Marker m2 = googleMap.addMarker(new MarkerOptions()
                .position(Ub)
                .anchor(0.5f, 0.5f)
                .title("University Building")
                .snippet("Snippet1")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_blue)));

        Marker m3 = googleMap.addMarker(new MarkerOptions()
                .position(TechPark)
                .anchor(0.5f, 0.5f)
                .title("Tech Park")
                .snippet("Snippet1")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_violet)));

        Marker m4 = googleMap.addMarker(new MarkerOptions()
                .position(Esb)
                .anchor(0.5f, 0.5f)
                .title("Electrical Science Block")
                .snippet("Snippet1")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_yellow)));
/*
        mMap.addMarker(new MarkerOptions().position(University).title("SRM University")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_green)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(University, 18));

        mMap.addMarker(new MarkerOptions().position(Ub).title("University Building")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_green)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Ub, 18));

        mMap.addMarker(new MarkerOptions().position(TechPark).title("Tech Park")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_green)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TechPark, 18));

        mMap.addMarker(new MarkerOptions().position(Esb).title("Electrical Science Block")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_green)));
        */

       mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Esb,15));
//mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(Esb,18));
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);

    }
}
