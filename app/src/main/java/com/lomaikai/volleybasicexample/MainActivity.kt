package com.lomaikai.volleybasicexample

import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import android.widget.TextView
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import com.android.volley.Request
import com.android.volley.toolbox.Volley
import com.android.volley.VolleyError

class MainActivity : AppCompatActivity() {
    private lateinit var mRequestQueue: RequestQueue
    private lateinit var mStringRequest: StringRequest
    private val url = "https://www.gutenberg.org/files/59281/59281-0.txt"
    private lateinit var output: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        output = findViewById(R.id.outputTextView)
        output.setMovementMethod(ScrollingMovementMethod())
    }

    fun sendAndRequestResponse(view: View?) {
        mRequestQueue = Volley.newRequestQueue(this)
        mStringRequest = StringRequest(
            Request.Method.GET,
            url,
            { response: String -> output.text = response }
        ) { error: VolleyError -> output.text = getString(R.string.errorNotice) + error }
        mRequestQueue.add(mStringRequest)
    }

    fun clearOutput(view: View?) {
        val t = findViewById<TextView>(R.id.outputTextView)
        t.setText(R.string.initialNotice)
    }
}