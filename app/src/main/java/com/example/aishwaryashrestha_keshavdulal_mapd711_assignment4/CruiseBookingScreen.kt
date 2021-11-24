package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class CruiseBookingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cruise_booking_screen)

        val bookButton = findViewById<Button>(R.id.buttonBookCruise)
//        val startDateTV = findViewById<Button>(R.id.buttonBookCruise)

        val cruiseSpinner: Spinner = findViewById(R.id.cruiseSpinner)
        val adultCounterSpinner: Spinner = findViewById(R.id.adultSpinner)
        val kidCounterSpinner: Spinner = findViewById(R.id.kidsSpinner)
        val seniorCounterSpinner: Spinner = findViewById(R.id.guestSpinner)


        bookButton.setOnClickListener() {
            val cruiseName: String = cruiseSpinner.selectedItem.toString()

            val adultCount: String = adultCounterSpinner.selectedItem.toString()
            val kidCount: String = kidCounterSpinner.selectedItem.toString()
            val seniorCount: String = seniorCounterSpinner.selectedItem.toString()
            val totalGuest: Int =adultCount.toInt()+kidCount.toInt()+seniorCount.toInt()

        }
    }
}
