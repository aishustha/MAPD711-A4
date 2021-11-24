package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginBtn = findViewById<Button>(R.id.buttonLogin)
        val registerBtn = findViewById<Button>(R.id.buttonRegister)

        val userNameET = findViewById<TextView>(R.id.loginUsernameTf)
        val passwordET = findViewById<TextView>(R.id.loginPasswordTf)

        // create a shared preference object
        val sharedPref: SharedPreferences = getSharedPreferences("userInfoSharedPref", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPref.edit()

        loginBtn.setOnClickListener {

            val username = userNameET.text.toString().trim()
            // val password = passwordET.text.toString().trim()

            // check if user exists
            if (true) {

                editor.apply {
                    putString("username", username)
                    // commit() // synchronous - runs on main thread
                    apply() // async - runs on parallel thread
                }

                // Show Success Message to User
                Toast.makeText(this@LoginScreen, "Login Successful", Toast.LENGTH_SHORT).show()

                // allow login to dashboard
                val intent = Intent(this@LoginScreen, DashboardScreen::class.java)
                startActivity(intent)
            } else {
                // Show Error Message to User
                Toast.makeText(this@LoginScreen, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }

        registerBtn.setOnClickListener {
            val intent = Intent(this@LoginScreen, UserRegistrationScreen::class.java)
            startActivity(intent)
        }
    }
}
