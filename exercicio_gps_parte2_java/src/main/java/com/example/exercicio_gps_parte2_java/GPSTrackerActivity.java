package com.example.exercicio_gps_parte2_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GPSTrackerActivity extends AppCompatActivity {
    private TextView latitudeValue;
    private TextView longitudeValue;

    private Button gpsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gps_tracker_layout);
        setTitle("Parte 2 - GPS");

        latitudeValue = (TextView)findViewById(R.id.text_latitude);
        longitudeValue = (TextView)findViewById(R.id.text_longitude);
        gpsButton = (Button)findViewById(R.id.button_gps);

        ActivityCompat.requestPermissions(GPSTrackerActivity.this, new
                String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);

        gpsButton.setOnClickListener(v -> {
            GPSTracker g = new GPSTracker(getApplicationContext());
            Location l = g.getLocation();
            if(l != null)
            {
                double lat = l.getLatitude();
                double longi = l.getLongitude();

                latitudeValue.setText("Latitude: " + String.valueOf(lat));
                longitudeValue.setText("Longitude: " + String.valueOf(longi));
            }
        });
    }
}