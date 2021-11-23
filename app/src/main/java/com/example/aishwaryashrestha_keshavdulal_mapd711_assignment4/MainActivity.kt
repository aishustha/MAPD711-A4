package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginBtn = findViewById<Button>(R.id.buttonLogin)
        val registerBtn = findViewById<Button>(R.id.buttonRegister)

        loginBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, Dashboard::class.java)
            startActivity(intent)
        }

        registerBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, Registration::class.java)
            startActivity(intent)
        }
    }
}