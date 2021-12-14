package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4.users.UserViewModel

class Checkout : AppCompatActivity() {
    lateinit var customerViewModel: UserViewModel
    lateinit var context: Context
    lateinit var user: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        //consider the Main Activity as a current context
        context = this@Checkout

        //initializing studentModel Object
        customerViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        // Adding previous values if user wants to make changes to them
        val name = findViewById<EditText>(R.id.ETname)
        val add = findViewById<EditText>(R.id.ETadd)
        val city = findViewById<EditText>(R.id.ETCity)
        val postcode = findViewById<EditText>(R.id.ETpost)
        val num = findViewById<EditText>(R.id.ETphone)
        val mail = findViewById<EditText>(R.id.ETmail)
        val username = findViewById<TextView>(R.id.tv23)

        val prefs = getSharedPreferences("User", Context.MODE_PRIVATE)
        val answer = prefs.getString("Username",null)
        //user.text = answer.toString()
        user = answer.toString().trim()
        var customer = customerViewModel.getCustomers(context,user)

        //observer and observe() used to work with live-data
        customerViewModel.getCustomers(context, user)!!.observe(this, Observer {

            if (it == null) {
                //name.text = " "
                Toast.makeText( context,"No Data", Toast.LENGTH_LONG).show()
            }
            else {
                username.text = it.City


            }
        })



    }

    fun cLickSend(view: android.view.View) {

        if (view.id == R.id.buttoncheck) {

            // Fetching values from previous intent
            val ctype = intent.getStringExtra("Cruise")
            val people = intent.getStringExtra("People")
            val places = intent.getStringExtra("Places")
            val duration = intent.getStringExtra("Duration")
            val cost = intent.getStringExtra("Price")
            val adults = intent.getStringExtra("Adults")
            val kids = intent.getStringExtra("Child")

            // Getting values from user
            val name = findViewById<EditText>(R.id.ETname)
            val add = findViewById<EditText>(R.id.ETadd)
            val city = findViewById<EditText>(R.id.ETCity)
            val postcode = findViewById<EditText>(R.id.ETpost)
            val num = findViewById<EditText>(R.id.ETphone)
            val mail = findViewById<EditText>(R.id.ETmail)




            val intent_4 = Intent(this@Checkout, Book::class.java)
            intent_4.putExtra("Cruise",ctype)
            intent_4.putExtra("People",people)
            intent_4.putExtra("Places",places)
            intent_4.putExtra("Duration",duration)
            intent_4.putExtra("Price",cost)
            intent_4.putExtra("Adults",adults)
            intent_4.putExtra("Child",kids)
            intent_4.putExtra("Name",name.text.toString())
            intent_4.putExtra("Address",add.text.toString())
            intent_4.putExtra("City",city.text.toString())
            intent_4.putExtra("Postcode",postcode.text.toString())
            intent_4.putExtra("Number",num.text.toString())
            intent_4.putExtra("Mail",mail.text.toString())

            startActivity(intent_4)
        }

    }
}