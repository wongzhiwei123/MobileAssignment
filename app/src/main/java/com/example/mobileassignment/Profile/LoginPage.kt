package com.example.mobileassignment.Profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.mobileassignment.R

class LoginPage : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login_page, container, false)
        val signIn: Button = view.findViewById(R.id.loginButton)
        signIn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_loginPage_to_nav_home)
        }

        val forgetPass: Button = view.findViewById(R.id.forgetPass)
        signIn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_loginPage_to_forgetPassword)
        }

        val signUpAcc: Button = view.findViewById(R.id.signUp)
        signIn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_loginPage_to_signUpAccount)
        }
        return view
    }

}