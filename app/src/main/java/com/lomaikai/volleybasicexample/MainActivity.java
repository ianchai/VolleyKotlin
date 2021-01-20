package com.lomaikai.volleybasicexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "http://www.mocky.io/v2/597c41390f0000d002f4dbd1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void sendAndRequestResponse(View view) {
        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);
        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET,
                url,
                response -> {
                    TextView t = findViewById(R.id.outputTextView);
                    t.setText(response.toString());
                },
                error -> {
                    TextView t = findViewById(R.id.outputTextView);
                    t.setText("Something went wrong: "+error);
                });
        mRequestQueue.add(mStringRequest);
    };

    private void clearOutput(View view) {
        TextView t = findViewById(R.id.outputTextView);
        t.setText("");
    }
}