package com.example.dbpractice2

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [tableStr::class],version=1)
abstract class methodExtend:RoomDatabase() {
    abstract  fun myDao():myDao
}