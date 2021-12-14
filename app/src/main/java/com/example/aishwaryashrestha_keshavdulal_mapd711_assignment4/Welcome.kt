package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val user = findViewById<TextView>(R.id.TVuname)
        val prefs = getSharedPreferences("User", Context.MODE_PRIVATE)
        val answer = prefs.getString("Username",null)
        user.text = answer.toString()
    }


    // Overriding create options menu function to add our custom menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_main,menu)
        return true

    }

    // Adding options selected logic
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // variables to store values specific to the type of cruise
        var selectedOption= ""
        var npeople = ""
        var visitingplaces = ""
        var duration = ""
        var price = ""


        when(item?.itemId) {

            R.id.checkbox1 -> selectedOption = "Bahamas"
            R.id.checkbox2 -> selectedOption = "Carribean"
            R.id.checkbox3 -> selectedOption = "Cuba"
            R.id.checkbox4 -> selectedOption = "Sampler"
            R.id.checkbox5 -> selectedOption = "Star"
        }
        if (selectedOption == "Bahamas") {
            npeople = "2"
            visitingplaces = "Atlantis, Nassau, Harbour Islands"
            duration = "4 nights"
            price = "5000 $"


        }

        if (selectedOption == "Carribean") {
            npeople = "4"
            visitingplaces = "Falmouth, Cococay,  Grand Cayman"
            duration = "3 nights"
            price = "7000 $"

        }

        if (selectedOption == "Cuba") {
            npeople = "1"
            visitingplaces = "Havana, Carnival Paradise"
            duration = "2 nights"
            price = "2000 $"

        }

        if (selectedOption == "Sampler") {
            npeople = "4"
            visitingplaces = "Phi Phi Islands"
            duration = "5 nights"
            price = "8000 $"

        }

        if (selectedOption == "Star") {
            npeople = "2"
            visitingplaces = "Nassau, Havana"
            duration = "4 nights"
            price = "5000 $"

        }


        val intent = Intent(this@Welcome, CruiseDetail::class.java)
        intent.putExtra("Cruise", selectedOption)
        intent.putExtra("People", npeople)
        intent.putExtra("Places", visitingplaces)
        intent.putExtra("Duration", duration)
        intent.putExtra("Price", price)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }
}