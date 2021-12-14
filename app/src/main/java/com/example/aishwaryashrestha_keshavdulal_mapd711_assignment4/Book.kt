package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Book : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        // Fetching values from previous intent
        val name = intent.getStringExtra("Name")
        val add = intent.getStringExtra("Address")
        val city = intent.getStringExtra("City")
        val ctype = intent.getStringExtra("Cruise")
        val places = intent.getStringExtra("Places")
        val duration = intent.getStringExtra("Duration")
        val people = intent.getStringExtra("People")
        val cost = intent.getStringExtra("Price")

        // getting textview fields to add value
        val customer = findViewById<TextView>(R.id.TVname)
        val address = findViewById<TextView>(R.id.TVadd)
        val city1 = findViewById<TextView>(R.id.TVcity)
        val cruise = findViewById<TextView>(R.id.TVcruise)
        val place = findViewById<TextView>(R.id.TVplace)
        val dur = findViewById<TextView>(R.id.TVdur)
        val npeople = findViewById<TextView>(R.id.TVguest)
        val price = findViewById<TextView>(R.id.TVprice)

        // Sending values to text view
        customer.text = name.toString()
        address.text = add.toString()
        city1.text = city.toString()
        cruise.text = ctype.toString()
        place.text = places.toString()
        dur.text = duration.toString()
        npeople.text = people.toString()
        price.text = cost.toString()

    }
}