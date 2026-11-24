package com.example.firstapp.presentation.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.databinding.ActivityRegisterUserBinding

class RegisterUser : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterUserBinding

    private val documentos = listOf<String>("CI. Identidad", "Pasaporte", "Partida nacimiento")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterUserBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            documentos
        )

        binding.autoComplete.setAdapter(adapter)

        binding.spinner.adapter = adapter

    }
}