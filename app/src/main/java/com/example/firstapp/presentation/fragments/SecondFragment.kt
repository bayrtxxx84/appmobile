package com.example.firstapp.presentation.fragments

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firstapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        binding.btnGMaps.setOnClickListener {

            //var pack = "com.google.android.apps.maps"
            val pack = "com.whatsapp.main"

            if(checkPackages(pack)) {
                val coord = Uri.parse(
                    "geo: -0.20146462601230658, " +
                            "-78.50727286446165 ?z=17"
                )
                val mapsIntent = Intent(Intent.ACTION_VIEW, coord)

                mapsIntent.setPackage(pack)

                mapsIntent.resolveActivity(requireContext().packageManager)?.let {
                    startActivity(mapsIntent)
                }
            }
            else {
                var playStore = Intent(Intent.ACTION_VIEW)
                playStore.setData(
                    (Uri.parse("https://play.google.com/store/search?q= ${pack} "))
                )
                startActivity(playStore)
            }

        }
    }


    private fun checkPackages(name: String): Boolean {

        return try {
            requireContext().packageManager.getPackageInfo(
                name,
                PackageManager.GET_ACTIVITIES
            )
            true
        } catch (ex: Exception) {
            Log.d("ERROR_APP", ex.message.toString())
            false
        }

    }


}