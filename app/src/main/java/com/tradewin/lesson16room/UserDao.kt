package com.tradewin.lesson16room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert
    fun saveUser(user: UserInfoModel)

    @Query("SELECT * FROM UserInfoModel")
    fun getAllUsers(): List<UserInfoModel>

    @Query("SELECT * FROM UserInfoModel")
    fun getAllUsersObserve(): LiveData<List<UserInfoModel>>

    @Delete
    fun deleteUser(user: UserInfoModel)

    @Query("SELECT * FROM UserInfoModel WHERE :userID = id LIMIT 1")
    fun getUser(userID: Int): UserInfoModel

    @Update
    fun updateUser(user: UserInfoModel?)
}