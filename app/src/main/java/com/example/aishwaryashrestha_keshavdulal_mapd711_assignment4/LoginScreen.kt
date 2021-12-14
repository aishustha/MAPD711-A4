package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginScreen : AppCompatActivity() {
    lateinit var context: Context
    lateinit var strName: String
    lateinit var strCourse: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        context = this@LoginScreen
    }

    //Function of login button
    fun login_button_click(view: android.view.View) {

        if (view.id == R.id.buttonlogin) {

            val username = findViewById<EditText>(R.id.ETUusername)
            val password = findViewById<EditText>(R.id.ETPassword)
            strName = username.text.toString().trim()
            strCourse = password.text.toString().trim()

            //validation for the empty values
            if (strName.isEmpty()) {
                username.error = "Enter User Name"
                Toast.makeText( context,"User Name should not be empty",Toast.LENGTH_LONG).show()
            }
            else if (strCourse.isEmpty()) {
                password.error = "Enter Password"
            }
            else{
                Toast.makeText( context,"Storing to database",Toast.LENGTH_LONG).show()

            }
            val prefs = getSharedPreferences("User",Context.MODE_PRIVATE)
            val editor = prefs.edit()

            editor.putString("Username",username.text.toString())
            editor.apply()



            val intent = Intent(this@LoginScreen, Welcome::class.java)
            val toast = Toast.makeText(applicationContext,"Login Successful",Toast.LENGTH_LONG)
            toast.show()
            startActivity(intent)


        }
    }

    // Function of Sign up button
    fun signup_button_click(view: android.view.View) {

        if (view.id == R.id.buttonsignup) {
            val intent = Intent(this@LoginScreen, UserRegistrationScreen::class.java)
            startActivity(intent)
        }
    }

}