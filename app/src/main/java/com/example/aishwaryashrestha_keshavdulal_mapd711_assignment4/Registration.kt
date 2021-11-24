package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import android.content.Context
import android.widget.Toast

class Registration : AppCompatActivity() {
    lateinit var userViewModel: UserViewModel
    lateinit var context: Context
    lateinit var username: String
    lateinit var password: String
    lateinit var firstname: String
    lateinit var lastname: String
    lateinit var address: String
    lateinit var city: String
    lateinit var postalCode: String
    lateinit var telephone: String
    lateinit var email: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        //consider the Main Activity as a current context
        context = this@Registration

        //initializing studentModel Object
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        var buttonRegister: Button = findViewById(R.id.register_btn)
        var usernameEdit: EditText = findViewById(R.id.username_tf)
        var passwordEdit: EditText = findViewById(R.id.password_tf)
        var firstnameEdit: EditText = findViewById(R.id.firstname_tf)
        var lastnameEdit: EditText = findViewById(R.id.lastname_tf)
        var addressEdit: EditText = findViewById(R.id.address_tf)
        var cityEdit: EditText = findViewById(R.id.city_tf)
        var postalCodeEdit: EditText = findViewById(R.id.postalCode_tf)
        var telephoneEdit: EditText = findViewById(R.id.telephone_tf)
        var emailEdit: EditText = findViewById(R.id.email_tf)

        buttonRegister.setOnClickListener {
            username = usernameEdit.toString().trim()
            password = passwordEdit.toString().trim()
            firstname = firstnameEdit.toString().trim()
            lastname = lastnameEdit.toString().trim()
            address = addressEdit.toString().trim()
            city = cityEdit.toString().trim()
            postalCode = postalCodeEdit.toString().trim()
            telephone = telephoneEdit.toString().trim()
            email = emailEdit.toString().trim()

            if (username.isEmpty() || password.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || address.isEmpty()
                || city.isEmpty() || postalCode.isEmpty() || telephone.isEmpty() || email.isEmpty()){
                Toast.makeText(context, "Please input all the fields!!", Toast.LENGTH_LONG).show()
            }
            else{
                userViewModel.insertCustomer(context, username, password, firstname, lastname, address, city, postalCode, telephone, email)
            }
        }
    }
}