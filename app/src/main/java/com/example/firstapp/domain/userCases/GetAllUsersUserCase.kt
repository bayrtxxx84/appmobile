package com.example.firstapp.domain.userCases

import android.content.Context
import com.example.firstapp.data.local.repository.AppDataBase
import com.example.firstapp.data.network.repositories.UserAPIRepository
import com.example.firstapp.domain.entities.UserUIEntity
import com.example.firstapp.domain.repository.UsersRepository

class GetAllUsersUserCase(private val context: Context) {

    suspend fun invoke(): List<UserUIEntity> =
        UsersRepository(
            db = AppDataBase.getInstanceDB(context),
            api = UserAPIRepository,
            context = context
        ).getAllUsers()

}