package com.example.remvp4.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PropertyDao {

    @Query("SELECT * FROM property_table")
    fun getAll(): LiveData<List<Property>>

    @Query("SELECT * FROM property_table WHERE projectName=:projectName")
    fun getOne(projectName: String): LiveData<Property>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(property: Property)

    @Delete
    suspend fun delete(property: Property)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(property: Property)



}