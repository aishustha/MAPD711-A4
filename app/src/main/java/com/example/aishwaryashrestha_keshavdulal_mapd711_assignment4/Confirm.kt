package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4.R.id.buttonguests

class Confirm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        // Adding spinner (adults)
//        val spin = findViewById<View>(R.id.adults_spin) as Spinner
//        val spin2 = findViewById<View>(R.id.child_spin) as Spinner
        val submit = findViewById<View>(buttonguests) as Button

        submit.setOnClickListener{
//            val text_sel = spin.selectedView as TextView
//            val text_child = spin2.selectedView as TextView

            // get values from previous intent
            val ctype = intent.getStringExtra("Cruise")
            val places = intent.getStringExtra("Places")
            val duration = intent.getStringExtra("Duration")
            val cost = intent.getStringExtra("Price")

            // Creating new intent
            val intent_2 = Intent(this@Confirm, Payment::class.java)
            intent_2.putExtra("Cruise",ctype.toString())
//            intent_2.putExtra("People",text_sel.text)
            intent_2.putExtra("Places",places.toString())
            intent_2.putExtra("Duration",duration.toString())
            intent_2.putExtra("Price",cost.toString())
//            intent_2.putExtra("Adults",text_sel.text)
//            intent_2.putExtra("Child",text_child.text)

            startActivity(intent_2)


        }

    }
}
