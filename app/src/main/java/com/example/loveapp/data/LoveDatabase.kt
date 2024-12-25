package com.example.loveapp.data

import androidx.room.RoomDatabase
import com.example.loveapp.data.local.ResultDao

abstract class LoveDatabase: RoomDatabase() {
    abstract fun loveDao(): ResultDao
}