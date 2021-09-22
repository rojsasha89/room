package com.tradewin.lesson16room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserInfoModel::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun getUserDao(): UserDao
}