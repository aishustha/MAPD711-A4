package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//database holder serves as main access point
@Database(entities = [User::class], version = 1, exportSchema = false)
    abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabaseUser(context: Context) : UserDatabase {

            if(INSTANCE != null ) return INSTANCE!!

            synchronized(this){
                INSTANCE = Room.databaseBuilder(context, UserDatabase::class.java, "USERDB")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!
            }
        }
    }
}