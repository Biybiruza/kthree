package com.biybiruza.datalifecenter.ui.splash

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.biybiruza.kthree.R
import com.biybiruza.kthree.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var binding: FragmentSplashBinding
    private lateinit var navController: NavController
    private lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)
        navController = Navigation.findNavController(requireActivity(), R.id.fragment_containerView)
        sharedPreferences = requireActivity().getSharedPreferences("settings",Context.MODE_PRIVATE)
        val type = sharedPreferences.getString("type","")

        Handler().postDelayed({
            if (onRegisterFinished()){
                findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_languageFragment)
            }
        },2000)

    }

    private fun onRegisterFinished() : Boolean {
        var sharedPreferences =
            requireActivity().getSharedPreferences("register", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("finished", false)
    }

}