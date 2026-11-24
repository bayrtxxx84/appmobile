package com.example.firstapp.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.databinding.ActivityLoginBinding
import com.example.firstapp.presentation.model.LoginModel
import com.google.android.material.snackbar.Snackbar

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    override fun onStart() {
        super.onStart()
        Snackbar.make(
            binding.txtUser,
            "Bienvenido",
            Snackbar.LENGTH_LONG
        ).show()
    }

    fun initListeners() {
        binding.boton1.setOnClickListener {

            val loginModel = LoginModel()

            val username = binding.txtUser.text.toString()
            val password = binding.txtPass.text.toString()

            if (loginModel.checkLogin(username, password)) {

                var mainIntent = Intent(
                    this,
                    MainActivity::class.java
                )

                val isAdmin = binding.switchAdmin.isChecked
                Log.d("FISTAPP", isAdmin.toString())

                mainIntent.putExtra("isAdmin", isAdmin)
                startActivity(mainIntent)

            } else {
                Snackbar.make(
                    binding.txtUser,
                    "Usuario/Password incorrecto",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }
 }