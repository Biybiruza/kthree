package com.biybiruza.datalifecenter.ui.main

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.biybiruza.kthree.R
import com.biybiruza.kthree.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: FragmentMainBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        sharedPreferences = requireActivity().getSharedPreferences("register", Context.MODE_PRIVATE)
        navController = Navigation.findNavController(requireActivity(),R.id.adminMainFragment)
        val editor = sharedPreferences.edit()
        editor.putBoolean("finished", true)
        editor.apply()

        binding.apply {
            bottomNavigation.background = null
            bottomNavigation.menu.getItem(2).isEnabled = false
            bottomNavigation.setupWithNavController(navController)

            floatAdd.setOnClickListener {
                navController.navigate(R.id.addCourseFragment)
            }
        }

    }
}