package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4.User

//contains the methods used for accessing the database
//all the necessary queries which we are going to execute in database
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCustomer(mainUser: User)

    @Query("SELECT * FROM mainUser WHERE username =:username AND password=:password ORDER BY userId ASC")
    fun getLoginDetails(username: String, password: String): LiveData<User>

    @Query("SELECT * FROM mainUser WHERE username =:username")
    fun getCustomer(username: String) : LiveData<User>

}