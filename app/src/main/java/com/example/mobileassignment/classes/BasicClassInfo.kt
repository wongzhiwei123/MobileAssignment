package com.example.mobileassignment.classes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.mobileassignment.R
import com.example.mobileassignment.databinding.FragmentBasicClassInfoBinding
import com.example.mobileassignment.databinding.FragmentCreateBasicClassBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BasicClassInfo : Fragment() {

    private lateinit var binding: FragmentBasicClassInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentBasicClassInfoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val database = Firebase.database("https://findyourcoach-3083a-default-rtdb.asia-southeast1.firebasedatabase.app/")
        val myRef = database.getReference("user")
        var className2 = requireArguments().getString("className1").toString()

        myRef.child("account1").get().addOnSuccessListener {
            binding.showClassname.text = it.child("Basic").child(className2).child("basicClassName").value.toString()
            className2 = it.child("Basic").child(className2).child("basicClassName").value.toString()
            binding.showDay.text = it.child("Basic").child(className2).child("basicTrainingDay").value.toString()
            binding.showTime.text = it.child("Basic").child(className2).child("basicTrainingTime").value.toString()
            binding.showDes.text = it.child("Basic").child(className2).child("basicDescription").value.toString()
        }.addOnFailureListener{
            //Log.e("firebase", "Error getting data", it)
        }

        binding.btnEdit.setOnClickListener{
            findNavController().navigate(R.id.action_basicClassInfo_to_editClassInfo, Bundle().apply {
                putString("className1", className2)
            })
        }

        binding.btnConfirm.setOnClickListener{
            Navigation.findNavController(root).navigate(R.id.action_basicClassInfo_to_basicClassDetails)
        }

        return binding.root
    }
}