package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4.User
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4.UserRepository

//provide data to the UI and survive configuration changes
//acts as a communication center between the Repository and teh UI

class UserViewModel : ViewModel() {
    var liveUserData: LiveData<User>? = null
    fun insertCustomer(context: Context, username: String, password: String, firstname: String, lastname: String,
                       address: String, city: String, postalCode: String,
                       telephone: String, email: String){
        UserRepository.insertUser(context, username, password,
            firstname, lastname, address, city, postalCode, telephone, email)
    }

    fun getUser(context: Context, username: String, password: String, firstname: String, lastname: String,
                    address: String, city: String, postalCode: String,
                    telephone: String, email: String) : LiveData<User>{
        liveUserData = UserRepository.getUserDetails(context, username)
        return liveUserData!!

    }

    fun getLogin(context: Context, username: String, password: String) : LiveData<User>{
        liveUserData = UserRepository.getLoginDetails(context, username, password)
        return liveUserData!!
    }
}