package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4.users

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    // calling repository tasks and
    // sending the results to the Activity
    var liveDataCustomer: LiveData<User>? = null

    //
    fun insertCustomer(
        context: Context,
        username: String,
        firstname: String,
        lastname: String,
        password: String,
        email: String,
        address: String,
        city: String,
        postalcode: String,
        phone: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            UserRepository.insertCustomer(
                context,
                username,
                firstname,
                lastname,
                password,
                email,
                address,
                city,
                postalcode,
                phone
            )
        }


    }
    fun getCustomers(context: Context, username: String): LiveData<User>? {
        //viewModelScope.launch  (Dispatchers.IO) {
        liveDataCustomer = UserRepository.getCustomers(context, username)
        return liveDataCustomer
        //}
    }
}