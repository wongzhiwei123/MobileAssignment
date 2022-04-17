package com.example.mobileassignment.Profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.mobileassignment.R

class SignUp : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        val signUp: Button = view.findViewById(R.id.signUpButton)
        signUp.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_signUpAccount_to_loginPage)
        }

        val signIn: Button = view.findViewById(R.id.alrMember)
        signIn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_signUpAccount_to_loginPage)
        }

        return view
    }

}