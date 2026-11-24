package com.example.firstapp.data.network.repositories

import com.example.firstapp.data.network.endpoints.RandomUsersEndpoints
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserAPIRepository {

    val execute: RandomUsersEndpoints by lazy {

        Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RandomUsersEndpoints::class.java)
    }
}