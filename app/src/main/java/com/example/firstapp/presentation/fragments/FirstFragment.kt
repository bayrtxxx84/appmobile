package com.example.firstapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.databinding.FragmentFirstBinding
import com.example.firstapp.domain.entities.UserUIEntity
import com.example.firstapp.domain.userCases.GetAllUsersUserCase
import com.example.firstapp.presentation.adapters.UserAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FirstFragment : Fragment() {


    private lateinit var binding: FragmentFirstBinding

    private lateinit var useradapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initListeners()
        initAdapters()
    }

    private fun initListeners() {

        binding.btnPresioname.setOnClickListener {
            Snackbar.make(
                binding.btnPresioname,
                "Estamos en el fragment 1",
                Snackbar.LENGTH_LONG
            )
                .show()
        }

    }


    private fun initAdapters() {

//        lifecycleScope.launch(Dispatchers.IO) {
//            var data = GetRandomUsersUserCase().invoke()
//
//            withContext(Dispatchers.Main) {
//                var useradapter = UserAdapter(data)
//                binding.rvListado1.adapter = useradapter
//                binding.rvListado1.layoutManager = GridLayoutManager(
//                    requireContext(),
//                    2
//                )
//            }
//        }

        lifecycleScope.launch(Dispatchers.Main) {

            binding.ldRV1.visibility = View.VISIBLE

            var data = withContext(Dispatchers.IO) {
                GetAllUsersUserCase(requireContext()).invoke()
            }

            useradapter = UserAdapter(
                data,
                { onSelectedItem(it) },
                { onDeleteItem(it) })

            binding.rvListado1.adapter = useradapter
            binding.rvListado1.layoutManager = GridLayoutManager(
                requireContext(),
                2
            )
            binding.ldRV1.visibility = View.GONE
        }

    }

    private fun onSelectedItem(item: UserUIEntity) {
        Snackbar.make(
            binding.ldRV1,
            item.first.toString(),
            Snackbar.LENGTH_LONG
        )
            .show()
    }

    private fun onDeleteItem(item: Int) {

        useradapter.notifyItemRemoved(item)

    }


    var cuadrado: (Int) -> Int = { it * it }

    private fun calcular(operation: (Int) -> Int, value: Int) {
        operation(value)
    }


}