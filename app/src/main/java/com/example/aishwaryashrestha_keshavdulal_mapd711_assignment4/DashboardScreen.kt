package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val profileBtn = findViewById<Button>(R.id.profile_btn)
        val addCruiseBtn = findViewById<Button>(R.id.add_cruise_btn)

        val sharedPref = getSharedPreferences("userInfoSharedPref", 0)
        val userName = sharedPref.getString("username", "")

        val dashBoardMessageTV = findViewById<TextView>(R.id.dashboardMessage_tv)
        dashBoardMessageTV.text = "Welcome to the Dashboard, ${userName.toString()}"


        profileBtn.setOnClickListener {
            val intent = Intent(this@DashboardScreen, UserProfileScreen::class.java)
            startActivity(intent)
        }

        addCruiseBtn.setOnClickListener {
            val intent = Intent(this@DashboardScreen, CruiseBookingScreen::class.java)
            startActivity(intent)
        }
    }
}
