package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
    }
    fun pay_button(view:android.view.View) {

        if (view.id == R.id.buttonpay) {

            // Fetching values from previous intent
            val ctype = intent.getStringExtra("Cruise")
            val people = intent.getStringExtra("People")
            val places = intent.getStringExtra("Places")
            val duration = intent.getStringExtra("Duration")
            val cost = intent.getStringExtra("Price")
            val adults = intent.getStringExtra("Adults")
            val kids = intent.getStringExtra("Child")

            //Creating new intent
            val intent_3 = Intent(this@Payment, Checkout::class.java)
            intent_3.putExtra("Cruise",ctype)
            intent_3.putExtra("People",people)
            intent_3.putExtra("Places",places)
            intent_3.putExtra("Duration",duration)
            intent_3.putExtra("Price",cost)
            intent_3.putExtra("Adults",adults)
            intent_3.putExtra("Child",kids)
            startActivity(intent_3)
        }
    }
}