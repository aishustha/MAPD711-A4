package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class CruiseDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cruise_detail)

        // Fetching required values from Intent
        val ctype = intent.getStringExtra("Cruise")
        val people = intent.getStringExtra("People")
        val places = intent.getStringExtra("Places")
        val duration = intent.getStringExtra("Duration")
        val cost = intent.getStringExtra("Price")

        // Getting Textviews from subactivity view
        val cruise = findViewById<TextView>(R.id.cruise)
        val visiting_places = findViewById<TextView>(R.id.places)
        //val npeople = findViewById<TextView>(R.id.people)
        val dur = findViewById<TextView>(R.id.duration)
        val price = findViewById<TextView>(R.id.price)

        // Assigning string values to subactivity fields
        cruise.text = ctype.toString()
        visiting_places.text = places.toString()
        //npeople.text = people.toString()
        dur.text = duration.toString()
        price.text = cost.toString()
    }
    // Button Submit method
    fun clickSubmit(view: View) {

        if (view.id == R.id.buttonSubmit) {
            val intent_1 = Intent(this@CruiseDetail, Confirm::class.java)

            var cr_type1 = findViewById<TextView>(R.id.cruise)
            //var people1 = findViewById<TextView>(R.id.people)
            var places1 = findViewById<TextView>(R.id.places)
            var duration1 = findViewById<TextView>(R.id.duration)
            var price1 = findViewById<TextView>(R.id.price)

            intent_1.putExtra("Cruise", cr_type1.text.toString())
            //intent_1.putExtra("People", people1.text.toString())
            intent_1.putExtra("Places", places1.text.toString())
            intent_1.putExtra("Duration", duration1.text.toString())
            intent_1.putExtra("Price", price1.text.toString())

            startActivity(intent_1)

        }
    }
}