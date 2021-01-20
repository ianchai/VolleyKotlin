package com.lomaikai.volleybasicexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "https://www.gutenberg.org/files/59281/59281-0.txt";
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.outputTextView);
        output.setMovementMethod(new ScrollingMovementMethod());
    }

    public void sendAndRequestResponse(View view) {
        mRequestQueue = Volley.newRequestQueue(this);  //mRequestQueue is a RequestQueue
        mStringRequest = new StringRequest(Request.Method.GET, //mStringRequest is a StringRequest
                url,
                response -> {
                    output.setText(response);
                },
                error -> {
                    output.setText(getString(R.string.errorNotice)+error);
                });
        mRequestQueue.add(mStringRequest);
    }

    public void clearOutput(View view) {
        TextView t = findViewById(R.id.outputTextView);
        t.setText(R.string.initialNotice);
    }
}