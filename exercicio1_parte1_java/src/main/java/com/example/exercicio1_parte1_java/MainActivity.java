package com.example.exercicio1_parte1_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;
    private Button btnSum;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Atividade 1");


        editText1 = (EditText)findViewById(R.id.editSum1);
        editText2 = (EditText)findViewById(R.id.editSum2);
        btnSum = (Button)findViewById(R.id.buttonSum);
        textResult = (TextView)findViewById(R.id.textResult);

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float number1 = Float.valueOf(editText1.getText().toString());
                float number2 = Float.valueOf(editText2.getText().toString());
                float sum = number1 + number2;

                textResult.setText(String.valueOf(sum));
            }
        });



    }
}