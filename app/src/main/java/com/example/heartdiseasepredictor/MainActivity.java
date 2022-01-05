package com.example.heartdiseasepredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText cp, thalach, slope, restecg, chol, trestbps, fbs, oldpeak;
    private Button predict;
    String url = "https://hearth-disease-prediction-app.herokuapp.com/predict";

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

        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cp.getText().toString().isEmpty()){
                    cp.setError("Cannot be Empty");
                }else if (thalach.getText().toString().isEmpty()){
                    thalach.setError("Cannot be Empty");
                }else if (slope.getText().toString().isEmpty()){
                    slope.setError("Cannot be Empty");
                }else if (restecg.getText().toString().isEmpty()){
                    restecg.setError("Cannot be Empty");
                }else if (chol.getText().toString().isEmpty()){
                    chol.setError("Cannot be Empty");
                }else if (trestbps.getText().toString().isEmpty()){
                    trestbps.setError("Cannot be Empty");
                }else if (fbs.getText().toString().isEmpty()){
                    fbs.setError("Cannot be Empty");
                }else if (oldpeak.getText().toString().isEmpty()){
                    oldpeak.setError("Cannot be Empty");
                }else {
                    //API -> Volley

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {

                                    try {
                                        JSONObject jsonObject = new JSONObject(response);
                                        String data = jsonObject.getString("hearth_disease");

                                        Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                                        intent.putExtra("result",data);
                                        startActivity(intent);

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
                            Log.d("API ERROR : ", error.getMessage().toString());
                        }
                    }){
                        @Override
                        protected Map<String,String> getParams(){
                            Map<String,String> params = new HashMap<String, String>();
                            params.put("cp",cp.getText().toString());
                            params.put("thalach",thalach.getText().toString());
                            params.put("slope",slope.getText().toString());
                            params.put("restecg",restecg.getText().toString());
                            params.put("chol",chol.getText().toString());
                            params.put("trestbps",trestbps.getText().toString());
                            params.put("fbs",fbs.getText().toString());
                            params.put("oldpeak",oldpeak.getText().toString());

                            return params;
                        }
                    };

                    RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                    queue.add(stringRequest);
                }
            }
        });
    }
}