package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4.User
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4.UserRepository

//provide data to the UI and survive configuration changes
//acts as a communication center between the Repository and teh UI

class UserViewModel : ViewModel() {
    var liveCustomerData: LiveData<User>? = null
    fun insertCustomer(context: Context, username: String, password: String, firstname: String, lastname: String,
                       address: String, city: String, postalCode: String,
                       telephone: String, email: String){
        UserRepository.insertCustomer(context, username, password,
            firstname, lastname, address, city, postalCode, telephone, email)
    }

    fun getCustomer(context: Context, username: String, password: String, firstname: String, lastname: String,
                    address: String, city: String, postalCode: String,
                    telephone: String, email: String) : LiveData<User>{
        liveCustomerData = UserRepository.getCustomerDetails(context, username)
        return liveCustomerData!!

    }

    fun getLogin(context: Context, username: String, password: String) : LiveData<User>{
        liveCustomerData = UserRepository.getLoginDetails(context, username, password)
        return liveCustomerData!!
    }
}