package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4.users

import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

// provide data to the UI and survive configuration changes
// acts as a communication center between the Repository and the UI

class UserViewModel : ViewModel() {

    // calling repository tasks and
    // sending the results to the Activity
    var liveUserData: LiveData<User>? = null

    fun insertCustomer(
        context: Context,
        username: String, password: String, firstname: String, lastname: String,
        address: String, city: String, postalCode: String,
        telephone: String, email: String
    ) {

        // input check
        if (registrationInputCheck(username, password)) {

            UserRepository.insertUser(
                context, username, password,
                firstname, lastname, address, city, postalCode, telephone, email
            )
            Toast.makeText(context, "Registration Successful!", Toast.LENGTH_SHORT)
                .show()
        } else {
            Toast.makeText(context, "Registration Failed!", Toast.LENGTH_SHORT)
                .show()

        }
    }

    private fun registrationInputCheck(username: String, password: String): Boolean {
        return !(TextUtils.isEmpty(username) && TextUtils.isEmpty(password))

    }

    fun getUser(
        context: Context, username: String, password: String, firstname: String, lastname: String,
        address: String, city: String, postalCode: String,
        telephone: String, email: String
    ): LiveData<User> {
        liveUserData = UserRepository.getUser(context, username)
        return liveUserData!!

    }

    fun getLogin(context: Context, username: String, password: String): LiveData<User> {
        liveUserData = UserRepository.getLogin(context, username, password)
        return liveUserData!!
    }
}
