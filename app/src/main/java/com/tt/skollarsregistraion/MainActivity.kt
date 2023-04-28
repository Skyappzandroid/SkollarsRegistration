package com.tt.skollarsregistraion

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.tt.skollarsregistraion.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var spot: String
    lateinit var visitor: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        spot = "http://52.66.205.22/event/registration/expo/Spot Register"
        visitor = "http://52.66.205.22/event/registration/General Entry 2023-2024"

        binding.spot.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@MainActivity,WebViewActivity::class.java).putExtra("type",spot))
        })

        binding.visitor.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@MainActivity,WebViewActivity::class.java).putExtra("type",visitor))
        })


    }

}