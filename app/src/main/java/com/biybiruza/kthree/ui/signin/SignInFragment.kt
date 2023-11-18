package com.biybiruza.datalifecenter.ui.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.biybiruza.kthree.MyShared
import com.biybiruza.kthree.R
import com.biybiruza.kthree.data.Users
import com.biybiruza.kthree.databinding.FragmentSignInBinding
import com.google.gson.Gson

class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    private lateinit var binding: FragmentSignInBinding
    private lateinit var myShared: MyShared
    private var list = listOf<Users>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignInBinding.bind(view)
        myShared = MyShared(requireActivity(), Gson())

        binding.apply {
            tvSignUp.setOnClickListener {
                findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
            }

            btnSignIn.setOnClickListener {

                list = myShared.getList("userList",Users::class.java)

                for (i in list.indices){
                    if (list[i].phoneNumber == etPhone.text.toString()){
                        findNavController().navigate(R.id.action_signInFragment_to_mainFragment)
                    } else{
                        Toast.makeText(requireActivity(),"You must create account", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }
}