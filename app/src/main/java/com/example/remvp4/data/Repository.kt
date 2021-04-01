package com.example.remvp4.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.remvp4.data.local.Property
import com.example.remvp4.data.local.PropertyDatabase
import javax.inject.Inject


class Repository @Inject constructor(private val propertyDatabase: PropertyDatabase) {

    fun getAll(): LiveData<List<Property>> {
        return propertyDatabase.propertyDao().getAll()
    }

    fun getOne(projectName: String): LiveData<Property> {
        return propertyDatabase.propertyDao().getOne(projectName)
    }


    suspend fun insert(property: Property) {
        return propertyDatabase.propertyDao().insert(property)
    }

    suspend fun delete(property: Property) {
        return propertyDatabase.propertyDao().delete(property)
    }

    suspend fun update(property: Property) {
        return propertyDatabase.propertyDao().update(property)
    }

}