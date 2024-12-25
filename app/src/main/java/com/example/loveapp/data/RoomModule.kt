package com.example.loveapp.data

import android.content.Context
import androidx.room.Room
import com.example.loveapp.data.local.ResultDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): LoveDatabase {
        return Room.databaseBuilder(
            context,
            LoveDatabase::class.java,
            "love_database"
        ).build()
    }

    @Provides
    fun provideLoveDao(database: LoveDatabase): ResultDao {
        return database.loveDao()
    }
}