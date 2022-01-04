package com.example.heartdiseasepredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText cp, thalach, slope, restecg, chol, trestbps, fbs, oldpeak;
    private Button predict;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cp = findViewById(R.id.cp);
        thalach = findViewById(R.id.thalach);
        slope = findViewById(R.id.slope);
        restecg = findViewById(R.id.restecg);
        chol = findViewById(R.id.chol);
        trestbps = findViewById(R.id.trestbps);
        fbs = findViewById(R.id.fbs);
        oldpeak = findViewById(R.id.oldpeak);
        predict = findViewById(R.id.predict);
        result = findViewById(R.id.result);

        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}