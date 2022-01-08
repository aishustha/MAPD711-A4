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
import androidx.lifecycle.Observer
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4.users.UserViewModel
import androidx.lifecycle.ViewModelProvider

class LoginScreen : AppCompatActivity() {
    lateinit var context: Context
//    lateinit var strName: String
//    lateinit var strCourse: String

    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        context = this@LoginScreen

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
    }

    // Function of Sign up button
    fun signup_button_click(view: android.view.View) {

        if (view.id == R.id.buttonsignup) {
            val intent = Intent(this@LoginScreen, UserRegistrationScreen::class.java)
            startActivity(intent)
        }
    }


    //Function of login button
    fun login_button_click(view: android.view.View) {

        if (view.id == R.id.buttonlogin) {

            val username = findViewById<TextView>(R.id.ETUsername)
            val password = findViewById<TextView>(R.id.ETPassword)
            //validation for the empty values
            if (username.text.isEmpty() || password.text.isEmpty()) {
                Toast.makeText(this, "You cannot leave any fields empty", Toast.LENGTH_LONG).show()
            } else {
                userViewModel.getCustomers(
                    context,
                    username.text.toString()
                )!!.observe(this, Observer {
                    if (it == null) {
                        Toast.makeText(applicationContext,"Incorrect Login Details",Toast.LENGTH_LONG).show()
                        username.text = ""
                        password.text = ""
                    }
                    else {


                        val prefs = getSharedPreferences("User", Context.MODE_PRIVATE)
                        val editor = prefs.edit()

                        editor.putString("Username", username.text.toString())
                        editor.apply()

                        val intent = Intent(this@LoginScreen, Welcome::class.java)
                        val toast =
                            Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_LONG)
                        toast.show()
                        startActivity(intent)
                    }
                })
                    }
                }

            }
    }


