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
            val modClassName = binding.modifyClassName.text.toString()
            val modDaySelected = binding.modifyDay.selectedItemPosition
            val modTimeSelected = binding.modifyTime.selectedItemPosition
            val modDes = binding.modifyDes.text.toString()
            var modDay = ""
            var modTime = ""

            if(modDaySelected == 0){
                modDay = "Monday"
            }
            else if (modDaySelected == 1){
                modDay = "Tuesday"
            }
            else if (modDaySelected == 2){
                modDay = "Wednesday"
            }
            else if (modDaySelected == 3){
                modDay = "Thursday"
            }
            else if (modDaySelected == 4){
                modDay = "Friday"
            }
            else if (modDaySelected == 5){
                modDay = "Saturday"
            }
            else if (modDaySelected == 6){
                modDay = "Sunday"
            }

            if(modTimeSelected == 0){
                modTime = "8:00am - 10:00am"
            }
            else if (modTimeSelected == 1){
                modTime = "10:00am - 12:00pm"
            }
            else if (modTimeSelected == 2){
                modTime = "1:00pm - 3:00pm"
            }
            else if (modTimeSelected == 3){
                modTime = "3:00pm - 5:00pm"
            }
            else if (modTimeSelected == 4){
                modTime = "5:00pm - 7:00pm"
            }
            else if (modTimeSelected == 5){
                modTime = "7:00pm - 9:00pm"
            }

            myRef.child("account1").child("Basic").child(className1).child("basicClassName").setValue(modClassName)
            myRef.child("account1").child("Basic").child(className1).child("basicTrainingDay").setValue(modDay)
            myRef.child("account1").child("Basic").child(className1).child("basicTrainingTime").setValue(modTime)
            myRef.child("account1").child("Basic").child(className1).child("basicDescription").setValue(modDes)
            Navigation.findNavController(root).navigate(R.id.action_editClassInfo_to_nav_classes)
        }
        return binding.root
    }


}