package com.example.mobileassignment.subscription

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.mobileassignment.R
import com.example.mobileassignment.databinding.FragmentPaymentMethodBinding
import com.example.mobileassignment.databinding.FragmentReceiptBinding


class ReceiptFragment : Fragment() {

    private lateinit var binding: FragmentReceiptBinding
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
        binding= FragmentReceiptBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val planS = requireArguments().getInt("plan")
        val monthS = requireArguments().getInt("month")
        val totalPay = requireArguments().getInt("total")
        val methods = requireArguments().getString("method")

        if(planS==1){
            binding.cLayoutOrder.isVisible=true
            binding.cLayoutOrder2.isVisible=false
            binding.selectedMonthB.text=monthS.toString()
            binding.reminder.isVisible=false
        }else if(planS==2){
            binding.cLayoutOrder.isVisible=false
            binding.cLayoutOrder2.isVisible=true
            binding.selectedMonthP.text=monthS.toString()
            binding.reminder.isVisible=true
        }
        binding.selectedMonthP.text=monthS.toString()
        binding.payment.text=totalPay.toString()
        binding.method.text=methods

        binding.button.setOnClickListener{
            Navigation.findNavController(root).navigate(R.id.action_receiptFragment_to_nav_home)
        }
        return binding.root
    }


}