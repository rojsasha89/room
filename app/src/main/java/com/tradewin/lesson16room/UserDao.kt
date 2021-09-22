package com.tradewin.lesson16room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun saveUser(user: UserInfoModel)

    @Query("SELECT * FROM UserInfoModel")
    fun getAllUsers(): List<UserInfoModel>
}