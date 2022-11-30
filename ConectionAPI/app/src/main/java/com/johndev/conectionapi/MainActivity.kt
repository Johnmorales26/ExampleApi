package com.johndev.conectionapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import com.johndev.conectionapi.databinding.ActivityMainBinding
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConection.setOnClickListener {
            // Instantiate the RequestQueue.
            val queue = Volley.newRequestQueue(this)
            val url = "https://catfact.ninja/fact"
            // Request a string response from the provided URL.
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                { response ->
                    // Display the first 500 characters of the response string.
                    binding.tvResponse.text = "Response is: ${response.toString().trim()}"
                },
                { binding.tvResponse.text = "That didn't work!" })
            // Add the request to the RequestQueue.
            queue.add(stringRequest)
        }
    }
}