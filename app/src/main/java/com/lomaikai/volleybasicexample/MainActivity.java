package com.lomaikai.volleybasicexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = getString(R.string.uri);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendAndRequestResponse(View view) {
        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);
        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET,
                url,
                response -> {
                    TextView t = findViewById(R.id.outputTextView);
                    t.setText(response);
                },
                error -> {
                    TextView t = findViewById(R.id.outputTextView);
                    t.setText(getString(R.string.errorNotice)+error);
                });
        mRequestQueue.add(mStringRequest);
    }

    public void clearOutput(View view) {
        TextView t = findViewById(R.id.outputTextView);
        t.setText(R.string.initialNotice);
    }
}