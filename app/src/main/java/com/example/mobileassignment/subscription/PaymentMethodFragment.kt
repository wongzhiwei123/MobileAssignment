package com.example.mobileassignment.subscription

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mobileassignment.R
import com.example.mobileassignment.databinding.FragmentPaymentMethodBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class PaymentMethodFragment : Fragment() {

    private lateinit var binding: FragmentPaymentMethodBinding
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
        binding= FragmentPaymentMethodBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val planS = requireArguments().getInt("planSelect")
        val monthS = requireArguments().getInt("month")
        val totalPay = requireArguments().getInt("total")
        val methods = requireArguments().getInt("method")

        val database = Firebase.database("https://findyourcoach-3083a-default-rtdb.asia-southeast1.firebasedatabase.app/")
        val myRef = database.getReference("user")

        binding.btnContinue.setOnClickListener{
            findNavController().navigate(R.id.action_paymentMethodFragment_to_receiptFragment, Bundle().apply {
                putInt("month", monthS)
                putInt("plan", planS)
                putInt("total", totalPay)
                putInt("method", methods)
            })
                if(planS==1){
                    myRef.child("account1").child("plan").setValue("Basic")
                }else if(planS==2){
                    myRef.child("account1").child("plan").setValue("Premium")
                }
        }


        return binding.root
    }


}