package com.example.firstapp.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.firstapp.R
import com.example.firstapp.databinding.ActivityMainBinding
import com.example.firstapp.presentation.fragments.FirstFragment
import com.example.firstapp.presentation.fragments.SecondFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var isAdmin: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        intent.extras.let {
            isAdmin = it?.getBoolean("isAdmin") ?: false
        }

        initListeners()
        changeFragment(FirstFragment())

    }


    private fun changeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frmLayout, fragment)
        transaction.commit()
        transaction.addToBackStack(null)
    }

    private fun initListeners() {

        binding.bottomNavigation.setOnItemSelectedListener { item ->

            when (item.itemId) {
                R.id.item1 -> {
                    changeFragment(FirstFragment())
                    true
                }

                R.id.item2 -> {
                    changeFragment(SecondFragment())
                    true
                }

                else -> {
                    false
                }
            }
        }
    }
}