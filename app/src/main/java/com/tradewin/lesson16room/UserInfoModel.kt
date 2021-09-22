package com.tradewin.lesson16room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserInfoModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val secondName: String
)