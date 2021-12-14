package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4.users

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//database holder serves as main access point
@Database(
    entities = [User::class],version = 1, exportSchema = false)
abstract class CustomerDatabase : RoomDatabase() {
    //instantiating Customer DAO object
    abstract fun customerDao() : UserDao

    //companion object means an object declaration inside a class
    companion object {

        //Volatile object or property is immediately made visible to other threads.
        @Volatile
        private var INSTANCE: CustomerDatabase? = null

        //create a database name "CustomerDB"
        fun getDatabaseClient(context: Context) : CustomerDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, CustomerDatabase::class.java, "CUSTOMERDB")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }
    }
}