package com.example.mobileassignment.subscription

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.mobileassignment.R
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

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

        val planSelected = requireArguments().getInt("itemID")



        //show the details for different plan

        val layoutBasic:ConstraintLayout = view.findViewById(R.id.cLayoutBasic)
        val layoutPremium:ConstraintLayout = view.findViewById(R.id.cLayoutPremium)

        val textBasic:TextView = view.findViewById(R.id.txtBasicTotal)
        val textPremium:TextView = view.findViewById(R.id.txtPremiumTotal)
        var calculation=0
//        val tester=1
        if(planSelected==1){
            layoutBasic.isVisible=true
            layoutPremium.isVisible=false
        }else if(planSelected==2){
            layoutBasic.isVisible=false
            layoutPremium.isVisible=true
        }

        //calculate payment
        val btn:Button = view.findViewById(R.id.calculateButton)
        var basicMonth=0
        var premiumMonth=0
        var totalP=0
        var finalMonth=0
        btn.setOnClickListener{
            basicMonth= view.findViewById<Spinner>(R.id.basic_month).selectedItemPosition
            premiumMonth= view.findViewById<Spinner>(R.id.premium_month).selectedItemPosition
            val subTotal:TextView=view.findViewById(R.id.subtotal)
            val processFee:TextView=view.findViewById(R.id.processingFee)
            val total:TextView=view.findViewById(R.id.totalPayment)
            if(planSelected==1){
                calculation=88*(basicMonth+1)
                finalMonth=basicMonth+1
                textBasic.text=calculation.toString()
            }else if(planSelected==2){
                calculation=188*(premiumMonth+1)
                finalMonth=premiumMonth+1
                textPremium.text=calculation.toString()
            }
            subTotal.text=String.format("%.2f",calculation*0.95)
            processFee.text=String.format("%.2f",calculation*0.05).toString()
            total.text=calculation.toString()
            totalP=calculation
        }

        //checkout button
        val database = Firebase.database("https://findyourcoach-3083a-default-rtdb.asia-southeast1.firebasedatabase.app/")
        val myRef = database.getReference("user")

        val checkout: Button = view.findViewById(R.id.btn_checkout)
        var method=0
        var monthS=0
        checkout.setOnClickListener{
            if(planSelected==1){
                myRef.child("account1").child("plan").setValue("Basic")
            }else if(planSelected==2){
                myRef.child("account1").child("plan").setValue("Premium")
            }
            method = view.findViewById<Spinner>(R.id.pay_spinner).selectedItemPosition+1
            if(planSelected==1){
                monthS=basicMonth
            }else if(planSelected==2){
                monthS=premiumMonth
            }
            if(method==1) {
                findNavController().navigate(R.id.action_checkoutFragment_to_paymentMethodFragment, Bundle().apply {
                    putInt("planSelect", planSelected)
                    putInt("month", finalMonth)
                    putInt("total", totalP)
                    putString("method", "Credit/Debit Card")
                })
//                Navigation.findNavController(view)
//                    .navigate(R.id.action_checkoutFragment_to_paymentMethodFragment)
            }else if(method==2){
                findNavController().navigate(R.id.action_checkoutFragment_to_receiptFragment, Bundle().apply {
                    putInt("planSelect", planSelected)
                    putInt("month", finalMonth)
                    putInt("total", totalP)
                    putString("method", "Cash")
                })
            }
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