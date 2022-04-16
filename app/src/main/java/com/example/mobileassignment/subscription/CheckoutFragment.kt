package com.example.mobileassignment.subscription

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.mobileassignment.R

class CheckoutFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_checkout, container, false)
        val checkout: Button = view.findViewById(R.id.btn_checkout)
        checkout.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_checkoutFragment_to_paymentMethodFragment)
        }
        return view
    }


}