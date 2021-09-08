package com.example.exercicio2_parte1_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMessageActivity extends AppCompatActivity {
    private EditText edtMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_message_layout);
        setTitle("Atividade 2");

        edtMessage = (EditText)findViewById(R.id.edtMessage);
        btnSend = (Button)findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = edtMessage.getText().toString();

                Intent sendIntent = new Intent(SendMessageActivity.this, ReceiveMessageActivity.class);
                sendIntent.putExtra("message", msg);
                startActivity(sendIntent);
            }
        });

    }
}