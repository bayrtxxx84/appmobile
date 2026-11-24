package com.example.firstapp.data.network.endpoints

import com.example.firstapp.data.network.entities.RandomUser
import retrofit2.http.GET

interface RandomUsersEndpoints {

    @GET("api/?results=100")
    suspend fun getOneUsersRandom() : RandomUser

}