package com.example.mobileassignment.Profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.mobileassignment.R
class ResetPass : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reset_pass, container, false)
        val reset: Button = view.findViewById(R.id.submitNewPass)
        reset.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_resetPass2_to_loginPage)
        }
        val back: Button = view.findViewById(R.id.backToLogin2)
        back.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_resetPass2_to_loginPage)
        }
        return view
    }

}