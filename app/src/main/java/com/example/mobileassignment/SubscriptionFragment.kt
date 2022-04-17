package com.example.mobileassignment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.mobileassignment.subscription.CheckoutFragment
import com.example.mobileassignment.subscription.PaymentMethodFragment
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


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

        val subscribed1:ImageView=view.findViewById(R.id.basicSubscribed)
        val subscribed2:ImageView=view.findViewById(R.id.premiumSubscribed)
        subscribed1.isVisible=false
        subscribed2.isVisible=false
        val btn1:Button=view.findViewById(R.id.btn_basic)
        val btn2:Button=view.findViewById(R.id.btn_premium)
        // Read from the database
        val database = Firebase.database("https://findyourcoach-3083a-default-rtdb.asia-southeast1.firebasedatabase.app/")
        val myRef = database.getReference("user")
        val test: TextView = view.findViewById(R.id.textView5)
        myRef.child("account1").child("plan").get().addOnSuccessListener {
            val type = it.value.toString()
            test.text=type
            if(type=="Basic"){
                btn1.isVisible=false
                subscribed1.isVisible=true
                btn2.isVisible=true
                subscribed2.isVisible=false
            }else if(type=="Premium"){
                btn1.isVisible=false
                subscribed1.isVisible=false
                btn2.isVisible=false
                subscribed2.isVisible=true
            }
        }.addOnFailureListener{
            //Log.e("firebase", "Error getting data", it)
        }

        val selectBasic: Button = view.findViewById(R.id.btn_basic)
        var selectedPlan = 0
        selectBasic.setOnClickListener{
            selectedPlan = 1
            findNavController().navigate(R.id.action_nav_subscription_to_checkoutFragment, Bundle().apply {
                putInt("itemID", selectedPlan)
            })
            //Navigation.findNavController(view).navigate(R.id.action_nav_subscription_to_checkoutFragment)

        }

        val selectPremium: Button = view.findViewById(R.id.btn_premium)
        selectPremium.setOnClickListener{
            selectedPlan = 2
            findNavController().navigate(R.id.action_nav_subscription_to_checkoutFragment, Bundle().apply {
                putInt("itemID", selectedPlan)
            })
//            Navigation.findNavController(view).navigate(R.id.action_nav_subscription_to_checkoutFragment)
//            selectedPlan = 2
        }


        return view
    }

}