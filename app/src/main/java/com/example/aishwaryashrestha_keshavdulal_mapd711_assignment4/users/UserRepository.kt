package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4.users

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

//abstracts access to multiple data sources
class UserRepository {


    //defining database and live data object as companion objects
    companion object {
        var customerDatabase: CustomerDatabase? = null
        var customerModel: LiveData<User>? = null


        //initialize database
        fun initializeDB(context: Context) : CustomerDatabase {
            return CustomerDatabase.getDatabaseClient(context)
        }

        //Initialize insertCustomer()
        fun insertCustomer(context: Context, username: String, firstname: String, lastname:String, password: String, email:String, address:String,city:String,postalcode:String,phone:String) {
            customerDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                val customerDetails = User(username, firstname,lastname,password,email,address,city,postalcode,phone)
                customerDatabase!!.customerDao().insertCustomer(customerDetails)
            }

        }

        //Initialize getCustomers()
        fun getCustomers(context: Context, username: String) : LiveData<User>? {

            customerDatabase = initializeDB(context)
            customerModel = customerDatabase!!.customerDao().getCustomers(username)
            return customerModel
        }

    }
}