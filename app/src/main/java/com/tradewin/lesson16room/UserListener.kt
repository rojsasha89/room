package com.tradewin.lesson16room

interface UserListener {
    fun deleteItem(user: UserInfoModel)
    fun updateItem(user: UserInfoModel)
    fun openDetails(user: UserInfoModel)
}