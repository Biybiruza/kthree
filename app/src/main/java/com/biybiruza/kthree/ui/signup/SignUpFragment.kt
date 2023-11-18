package com.biybiruza.datalifecenter.ui.signup

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.biybiruza.kthree.MyShared
import com.biybiruza.kthree.R
import com.biybiruza.kthree.data.Users
import com.biybiruza.kthree.databinding.FragmentSignUpBinding
import com.google.gson.Gson

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var list: ArrayList<Users>
    private lateinit var myShared: MyShared

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpBinding.bind(view)
        sharedPreferences =
            requireActivity().getSharedPreferences("settings", Context.MODE_PRIVATE)
        val editor = requireActivity().getSharedPreferences("settings",Context.MODE_PRIVATE).edit()
        myShared = MyShared(requireActivity(), Gson())
        list = arrayListOf()

        binding.apply {

            cvBack.setOnClickListener {
                requireActivity().onBackPressed()
            }

            btnSignup.setOnClickListener {
                if (etName.text.toString() == "") {
                    toast("name")
                } else if (etLastName.text.toString() == "") {
                    toast("last name")
                } else if (etPhone.text.toString() == "") {
                    toast("phone number")
                } else if (etPassword.text.toString() == "") {
                    toast("password")
                } else {
                    list.add(
                        Users(
                            etName.text.toString(),
                            etLastName.text.toString(),
                            etPhone.text.toString()
                        )
                    )
                    myShared.putList("userList",list)
                    editor.putBoolean("loggInEd", true)
                    editor.apply()

                    findNavController().navigate(R.id.action_signUpFragment_to_mainFragment)
                }
            }
        }
    }

    private fun toast(str1: String) {
        Toast.makeText(requireActivity(), "Enter your $str1, please!!", Toast.LENGTH_SHORT).show()
    }
}