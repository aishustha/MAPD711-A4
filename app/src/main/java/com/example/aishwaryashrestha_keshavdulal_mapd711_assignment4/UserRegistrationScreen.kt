package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4.users.UserViewModel

class UserRegistrationScreen : AppCompatActivity() {

    lateinit var userViewModel: UserViewModel
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        context = this@UserRegistrationScreen

        setContentView(R.layout.activity_registration)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        var saveBtn = findViewById<Button>(R.id.btn_save)


        val fname = findViewById<EditText>(R.id.ETname)
        val lname = findViewById<EditText>(R.id.ETlname)
        val email = findViewById<EditText>(R.id.ETemail)
        val uname = findViewById<EditText>(R.id.ETuser)
        val password = findViewById<EditText>(R.id.ETpassword)
        val address = findViewById<EditText>(R.id.ETadd)
        val city = findViewById<EditText>(R.id.ETcity)
        val pcode = findViewById<EditText>(R.id.ETpcode)
        val phone = findViewById<EditText>(R.id.ETphone)

        saveBtn.setOnClickListener {
            var Username = uname.text.toString().trim()
            var Password = password.text.toString().trim()
            var Firstname = fname.text.toString().trim()
            var Lastname = lname.text.toString().trim()
            var Address = address.text.toString().trim()
            var City = city.text.toString().trim()
            var Postalcode = pcode.text.toString().trim()
            var Phone = phone.text.toString().trim()
            var Email = email.text.toString().trim()



            if (Username.isEmpty() || Password.isEmpty() || Firstname.isEmpty() || Lastname.isEmpty() || Address.isEmpty() || City.isEmpty() || Postalcode.isEmpty()
                || Phone.isEmpty() || Email.isEmpty()
            ) {
                Toast.makeText(this, "Cannot leave any fields empty", Toast.LENGTH_SHORT).show()
            } else {
                userViewModel.insertCustomer(
                    context,
                    Username,
                    Password,
                    Firstname,
                    Lastname,
                    Address,
                    City,
                    Postalcode,
                    Phone,
                    Email
                )
//                editor.putString("username", Username)
//                editor.commit()
                Toast.makeText(this, "Succesfully Registered", Toast.LENGTH_SHORT).show()
                intent = Intent(this@UserRegistrationScreen, LoginScreen::class.java)
                intent.putExtra("UserName", Username)
                startActivity(intent)

            }

        }
    }

}


//        // Function of Save button
//        fun save_button(view: android.view.View) {
//
//            if (view.id == R.id.btn_save) {
//
//                // Fetching values from user
//                val fname = findViewById<EditText>(R.id.ETname)
//                val lname = findViewById<EditText>(R.id.ETlname)
//                val email = findViewById<EditText>(R.id.ETemail)
//                val uname = findViewById<EditText>(R.id.ETuser)
//                val password = findViewById<EditText>(R.id.ETpassword)
//                val address = findViewById<EditText>(R.id.ETadd)
//                val city = findViewById<EditText>(R.id.ETcity)
//                val pcode = findViewById<EditText>(R.id.ETpcode)
//                val phone = findViewById<EditText>(R.id.ETphone)


//                val intent = Intent(this@UserRegistrationScreen, UserProfileScreen::class.java)
//                intent.putExtra("Fname",fname.text.toString())
//                intent.putExtra("Lname",lname.text.toString())
//                intent.putExtra("Email",email.text.toString())
//                intent.putExtra("Username",uname.text.toString())
//                intent.putExtra("Password",password.text.toString())
//                intent.putExtra("Address",address.text.toString())
//                intent.putExtra("City",city.text.toString())
//                intent.putExtra("Pcode",pcode.text.toString())
//                intent.putExtra("Phone",phone.text.toString())
//                startActivity(intent)





//
//            }
//        }
//    }