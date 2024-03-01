package com.example.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface ContactDao {

    @Upsert   //the annotation gives us the implementation combi of update and insert
    suspend fun upsertContact(contact:Contact)

    @Delete
    suspend fun deleteContact(contact:Contact)

    @Query("SELECT * FROM contact ORDER BY firstName ASC")
    fun getContactsOrderedByFirstName():List<Contact>

    @Query("SELECT * FROM contact ORDER BY lastName ASC")
    fun getContactsOrderedByLastName():List<Contact>

    @Query("SELECT * FROM contact ORDER BY firstName ASC")
    fun getContactsOrderedByPhoneName():List<Contact>



}