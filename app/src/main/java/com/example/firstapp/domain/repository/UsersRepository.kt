package com.example.firstapp.domain.repository

import android.content.Context
import com.example.firstapp.data.local.repository.AppDataBase
import com.example.firstapp.data.local.entities.UserDBEntity
import com.example.firstapp.data.mappers.toUserDBEntity
import com.example.firstapp.data.mappers.toUserUIEntity
import com.example.firstapp.data.network.repositories.UserAPIRepository
import com.example.firstapp.domain.entities.UserUIEntity

class UsersRepository(
    private val db: AppDataBase,
    private val api : UserAPIRepository,
    private val context: Context
) {

    suspend fun saveUsers(users: List<UserUIEntity>) {

        val items = mutableListOf<UserDBEntity>()
        users.forEach {
            items.add(it.toUserDBEntity())
        }
        db.UserDBDao().insertUser(items.toList())
    }

    suspend fun getAllUsers() : List<UserUIEntity> {
        var items = mutableListOf<UserUIEntity>()
        val usersList = AppDataBase.getInstanceDB(context).UserDBDao().getAllUsers()
        if (usersList.isEmpty()) {

            val newItems = mutableListOf<UserDBEntity>()
            val call = api.execute.getOneUsersRandom()

            if (call.results.isNotEmpty()) {
                call.results.forEach { item ->
                    items.add(item.toUserUIEntity())
                    newItems.add(item.toUserDBEntity())
                }
                db.UserDBDao().insertUser(newItems)
            }
        } else {
            usersList.forEach {
                items.add(it.toUserUIEntity())
            }
        }
        return items
    }

}