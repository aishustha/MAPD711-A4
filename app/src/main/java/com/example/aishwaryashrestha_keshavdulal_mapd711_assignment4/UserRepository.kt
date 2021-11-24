package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//abstracts access to multiple data sources
class UserRepository() {

    companion object {
        var userDatabase: UserDatabase? = null
        var userModel: LiveData<User>? = null

        //initialize database
        fun initializeDB(context: Context): UserDatabase {
            return UserDatabase.getDatabaseUser(context)
        }

        //Initialize insertCustomer()
        fun insertUser(
            context: Context, username: String,
            password: String, firstname: String, lastname: String,
            address: String, city: String, postalCode: String,
            telephone: String, email: String
        ) {
            userDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                val userDetails = User(
                    username, password,
                    firstname, lastname, address, city, postalCode, telephone, email
                )
                userDatabase!!.userDao().addCustomer(userDetails)
            }

        }

        fun getUser(context: Context, firstname: String) : LiveData<User>{
            userDatabase = initializeDB(context)
            userModel = userDatabase!!.userDao().getUser(firstname)
            return userModel!!
        }

        fun getLogin(
            context: Context,
            username: String,
            password: String
        ): LiveData<User>? {
            userDatabase = initializeDB(context)
            userModel = userDatabase!!.userDao().getLogin(username, password)
            return userModel
        }
    }
}

