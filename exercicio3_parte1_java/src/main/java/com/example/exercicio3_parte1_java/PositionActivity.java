package com.example.exercicio3_parte1_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PositionActivity extends AppCompatActivity {
    TextView positionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.position_activity_layout);
        setTitle("Atividade 3");

        positionText = (TextView)findViewById(R.id.text_position);
        positionText.setText("Posição Correta");
    }
}