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
import com.example.mobileassignment.databinding.FragmentEditClassInfoBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class EditClassInfo : Fragment() {

    private lateinit var binding: FragmentEditClassInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentEditClassInfoBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val className1 = requireArguments().getString("className1").toString()
        val database = Firebase.database("https://findyourcoach-3083a-default-rtdb.asia-southeast1.firebasedatabase.app/")
        val myRef = database.getReference("user")



        binding.btnModify.setOnClickListener{
//            val modClassName = binding.modifyClassName.text
//            val modDay = binding.modifyClassName.text
//            val modTime = binding.modifyClassName.text
//            val modDes = binding.modifyDes.text
//
//            myRef.child("account1").child("Basic").child(className1).child("basicClassName").setValue(modClassName)
//            myRef.child("account1").child("Basic").child(className1).child("basicTrainingDay").setValue(modDay)
//            myRef.child("account1").child("Basic").child(className1).child("basicTrainingTime").setValue(modTime)
//            myRef.child("account1").child("Basic").child(className1).child("basicDescription").setValue(modDes)
            Navigation.findNavController(root).navigate(R.id.action_editClassInfo_to_nav_classes)
        }
        return binding.root
    }


}