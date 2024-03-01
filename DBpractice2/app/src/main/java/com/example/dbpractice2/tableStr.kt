package com.example.dbpractice2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Name")
data class tableStr(
    @PrimaryKey
    val id:Int,
    val data:String
)