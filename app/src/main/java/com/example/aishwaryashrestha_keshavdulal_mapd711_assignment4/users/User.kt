package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment4.users

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer")
data class User(
//defining a column FirstName
    @ColumnInfo(name = "firstname")
    var FirstName: String,
    //defining a column LastName
    @ColumnInfo(name = "lastname")
    var LastName: String,
    //defining a column UserName
    @ColumnInfo(name = "username")
    var UserName: String,
    //defining a column Password
    @ColumnInfo(name = "password")
    var Password: String,
    //defining a column Email
    @ColumnInfo(name = "email")
    var Email: String,
    //defining a column Address
    @ColumnInfo(name = "address")
    var address: String,
    //defining a column City
    @ColumnInfo(name = "city")
    var City: String,
    //defining a column PostalCode
    @ColumnInfo(name = "postcode")
    var PostalCode: String,
    //defining a column Phone
    @ColumnInfo(name = "phone")
    var Phone: String,

    )
{
    //defining a primary key field Id
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "customerid")
    var customerId: Int? = null
}
