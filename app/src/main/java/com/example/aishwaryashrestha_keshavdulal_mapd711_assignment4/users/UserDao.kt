package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4.users

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//contains the methods used for accessing the database
//all the necessary queries which we are going to execute in database
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCustomer(user: User)

    //defining a query method using @Query Annotation
    @Query("SELECT * FROM user_table WHERE username=:userName")
    fun getUser(userName: String?): LiveData<User>

    @Query("SELECT * FROM user_table WHERE username=:userName AND password=:password")
    fun getLogin(userName: String?, password: String?): LiveData<User>

}
