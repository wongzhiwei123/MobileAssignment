package com.example.mobileassignment.subscription

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.mobileassignment.R
import com.google.android.material.bottomnavigation.BottomNavigationView

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

        //val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        //view.bottomNavigation.menu.findItem(R.id.menu_item).isVisible = false
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        bottomNavigationView.visibility = View.GONE
    }
}