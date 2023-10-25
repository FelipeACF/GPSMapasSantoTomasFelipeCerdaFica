package com.example.actividad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
    EditText txtLatitud, txtLongitud;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLatitud = findViewById(R.id.txt_latitud);
        txtLongitud = findViewById(R.id.txt_longitud);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap){
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        Sede("ST Arica", -18.4833856, -70.3103754);
        Sede("ST Iquique", -20.2397762, -70.1448787);
        Sede("ST Antofagasta", -23.6347315, -70.3940526);
        Sede("ST La Serena", -29.9051257, -71.2638824);
        Sede("ST Viña del Mar", -33.4489738, -70.6607805);
        Sede("ST Santiago", -35.4287087, -71.672915);
        Sede("ST Talca", -36.8265352, -73.0639887);
        Sede("ST Concepción", -37.4720562, -72.3539949);
        Sede("ST Los Ángeles", -38.7391658, -72.5969291);
        Sede("ST Temuco", -38.7391658, -72.5969291);
        Sede("ST Valdivia", -39.8174169, -73.2331328);
        Sede("ST Osorno", -40.5717908, -73.1377152);
        Sede("ST Puerto Montt", -38.7391658, -72.5969291);

    }
    private void Sede(String title, double latitude, double longitude) {
        LatLng locations = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(locations).title(title));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(locations));
    }
    @Override
    public void onMapClick(@NonNull LatLng latLng){
        txtLatitud.setText("" + latLng.latitude);
        txtLongitud.setText("" + latLng.longitude);
    }
    public void Video (View view){
        Intent vid = new Intent(this, SantoTomas.class);
        startActivity(vid);
    }
    @Override
    public void onMapLongClick(@NonNull LatLng latLng){
        txtLatitud.setText("" + latLng.latitude);
        txtLongitud.setText("" + latLng.longitude);
    }

}