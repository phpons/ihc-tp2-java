package com.example.exercicio2_parte1_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {
    private TextView textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receive_message_layout);
        setTitle("Atividade 2");

        textMessage = (TextView)findViewById(R.id.textMessage);

        String message = getIntent().getStringExtra("message");
        textMessage.setText(message);
    }
}