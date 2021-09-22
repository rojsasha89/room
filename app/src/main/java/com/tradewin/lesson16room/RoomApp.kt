package com.tradewin.lesson16room

import android.app.Application
import androidx.room.Room

class RoomApp : Application() {

    override fun onCreate() {
        super.onCreate()
        DB = Room.databaseBuilder(this, AppDataBase::class.java, "myFirstDB")
            .allowMainThreadQueries()
            .build()
    }

    companion object {
        var DB: AppDataBase? = null
    }
}