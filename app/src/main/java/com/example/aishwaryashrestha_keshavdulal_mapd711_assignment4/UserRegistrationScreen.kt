package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import android.content.Context
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

        //consider the current Activity as a current context
        context = this@UserRegistrationScreen

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
            username = usernameEdit.text.toString().trim()
            password = passwordEdit.text.toString().trim()
            firstname = firstnameEdit.text.toString().trim()
            lastname = lastnameEdit.text.toString().trim()
            address = addressEdit.text.toString().trim()
            city = cityEdit.text.toString().trim()
            postalCode = postalCodeEdit.text.toString().trim()
            telephone = telephoneEdit.text.toString().trim()
            email = emailEdit.text.toString().trim()

            println("🐞 ${username}, ${password}, ${firstname} ${TextUtils.isEmpty(username)}", )

            if (TextUtils.isEmpty(username) || password.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || address.isEmpty()
                || city.isEmpty() || postalCode.isEmpty() || telephone.isEmpty() || email.isEmpty()
            ) {
                Toast.makeText(context, "Please enter the fields!!", Toast.LENGTH_LONG).show()
            } else {
                userViewModel.insertCustomer(
                    context,
                    username,
                    password,
                    firstname,
                    lastname,
                    address,
                    city,
                    postalCode,
                    telephone,
                    email
                )
            }
        }
    }
}
