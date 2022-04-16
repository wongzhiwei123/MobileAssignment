package com.example.mobileassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.mobileassignment.R
import com.example.mobileassignment.subscription.CheckoutFragment

/**
 * A simple [Fragment] subclass.
 * Use the [SubscriptionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SubscriptionFragment : Fragment() {


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
        val view = inflater.inflate(R.layout.fragment_subscription, container, false)
        val select_basic: Button = view.findViewById(R.id.btn_basic)
        select_basic.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_nav_subscription_to_checkoutFragment)
        }

        val select_premium: Button = view.findViewById(R.id.btn_premium)
        select_premium.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_nav_subscription_to_addBasisClass)
        }
        return view
    }


}