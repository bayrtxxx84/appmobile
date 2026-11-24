package com.example.firstapp.data.local.dao

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.Query
import com.example.firstapp.data.local.entities.UserDBEntity


@Dao
interface UserDBDao {

    @Query("select * from UserDBEntity")
    suspend fun getAllUsers(): List<UserDBEntity>

    @Query("select * from UserDBEntity where idValue = :id")
    suspend fun getOneUserForID(id: String): UserDBEntity

    @Delete
    suspend fun deleteUser(us: UserDBEntity)

    @Query("Delete from UserDBEntity")
    suspend fun deleteAllUsers()

    @Insert
    suspend fun insertUser(us: List<UserDBEntity>
    )

}