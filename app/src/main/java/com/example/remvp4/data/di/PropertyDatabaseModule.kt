package com.example.remvp4.data.di

import android.app.Application
import androidx.room.Room
import com.example.remvp4.data.local.PropertyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DATABASE_NAME = "property_database"

@Module
@InstallIn(SingletonComponent::class)
object PropertyDataBaseModule {

    @Provides
    @Singleton
    fun providesPropertyDatabase(context: Application): PropertyDatabase {
        return Room.databaseBuilder(
            context,
            PropertyDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}