package com.example.firstapp.data.local.entities

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity
data class UserDBEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val email: String,
    val gender: String,
    val idName: String,
    val idValue: String,
    val password: String,
    val first: String,
    val last: String,
    val phone: String,
    val picture: String,
)