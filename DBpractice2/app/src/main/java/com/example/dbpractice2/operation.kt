package com.example.dbpractice2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.jar.Attributes

@Dao
interface myDao{
    @Query("SELECT * FROM Name")
    fun getAll():List<tableStr>

    @Insert
    fun insert(entity: tableStr)
}