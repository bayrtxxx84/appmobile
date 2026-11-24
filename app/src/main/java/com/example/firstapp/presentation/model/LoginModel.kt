package com.example.firstapp.presentation.model

class LoginModel {

    fun checkLogin(username: String, password: String): Boolean =
        username == "admin" && password == "admin"

}