package com.example.mobileassignment.Profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.mobileassignment.R

class ForgetPass : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_forget_pass, container, false)
        val verifyBtn: Button = view.findViewById(R.id.verifyButton)
        verifyBtn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_forgetPassword_to_resetPass2)
        }
        val backBtn: Button = view.findViewById(R.id.backToLogin1)
        backBtn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_signUpAccount_to_loginPage)
        }
        return view
    }

}