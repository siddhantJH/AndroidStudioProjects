package com.example.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact (
    //for making the primary keys
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val firstName:String,
    val lastName:String,
    val phoneNumber:String
)
