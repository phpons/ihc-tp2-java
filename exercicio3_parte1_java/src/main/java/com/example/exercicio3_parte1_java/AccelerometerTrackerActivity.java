package com.example.exercicio3_parte1_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

public class AccelerometerTrackerActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor accelerometerSensor;

    private EditText edtXAxis;
    private EditText edtYAxis;
    private EditText edtZAxis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accelerometer_tracker_layout);
        setTitle("Atividade 3");

        edtXAxis = (EditText)findViewById(R.id.editXAxis);
        edtYAxis = (EditText)findViewById(R.id.editYAxis);
        edtZAxis = (EditText)findViewById(R.id.editZAxis);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            edtXAxis.setText(String.valueOf(x));
            edtYAxis.setText(String.valueOf(y));
            edtZAxis.setText(String.valueOf(z));

            if (Math.sqrt(x*x+y*y+z*z) > 17) {
                startActivity(new Intent(AccelerometerTrackerActivity.this, PositionActivity.class));
            }
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
    }
}