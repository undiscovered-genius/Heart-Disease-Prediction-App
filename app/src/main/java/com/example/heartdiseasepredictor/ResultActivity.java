package com.example.heartdiseasepredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import me.ibrahimsn.lib.Speedometer;

public class ResultActivity extends AppCompatActivity {

    Speedometer speedometer;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        speedometer = findViewById(R.id.speedometer);
        result = findViewById(R.id.result);

        Intent intent = getIntent();

        String data = intent.getStringExtra("result");
        if (data.equals("1")){
            speedometer.setFillColor(Color.parseColor("#EC4C4C"));
            result.setText("Chances of Heart Disease");
            speedometer.setSpeed(81,1000L,null);
            speedometer.animate();
        }else {
            speedometer.setFillColor(Color.parseColor("#5BDEAC"));
            result.setText("Chances of No Heart Disease");
            speedometer.setSpeed(81,1000L,null);
            speedometer.animate();
        }

    }
}