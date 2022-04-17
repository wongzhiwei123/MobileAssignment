package com.example.mobileassignment.classes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.mobileassignment.R
import com.example.mobileassignment.databinding.FragmentCreateBasicClassBinding
import com.example.mobileassignment.databinding.FragmentReceiptBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.sql.DatabaseMetaData


class CreateBasicClass : Fragment() {


    private lateinit var binding: FragmentCreateBasicClassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCreateBasicClassBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnCreate1.setOnClickListener{
            var trainingDay = ""
            var trainingTime= ""
            val className = binding.editClassName.text.toString()
            val trainingDaySelect = binding.spinnerDay1.selectedItemPosition
            val trainingTimeSelect = binding.spinnerTime1.selectedItemPosition
            val description = binding.editDescription.text.toString()


            if(trainingDaySelect == 0){
                trainingDay = "Monday"
            }
            else if (trainingDaySelect == 1){
                trainingDay = "Tuesday"
            }
            else if (trainingDaySelect == 2){
                trainingDay = "Wednesday"
            }
            else if (trainingDaySelect == 3){
                trainingDay = "Thursday"
            }
            else if (trainingDaySelect == 4){
                trainingDay = "Friday"
            }
            else if (trainingDaySelect == 5){
                trainingDay = "Saturday"
            }
            else if (trainingDaySelect == 6){
                trainingDay = "Sunday"
            }

            if(trainingTimeSelect == 0){
                trainingTime = "8:00am - 10:00am"
            }
            else if (trainingTimeSelect == 1){
                trainingTime = "10:00am - 12:00pm"
            }
            else if (trainingTimeSelect == 2){
                trainingTime = "1:00pm - 3:00pm"
            }
            else if (trainingTimeSelect == 3){
                trainingTime = "3:00pm - 5:00pm"
            }
            else if (trainingTimeSelect == 4){
                trainingTime = "5:00pm - 7:00pm"
            }
            else if (trainingTimeSelect == 5){
                trainingTime = "7:00pm - 9:00pm"
            }


            var maximumBasisClass = 0
            var basicClassNumber = 0
            var type ="";

            val basicClass = BasicClass(className,trainingDay,trainingTime,description)
            val database = Firebase.database("https://findyourcoach-3083a-default-rtdb.asia-southeast1.firebasedatabase.app/")
            val myRef = database.getReference("user")

            myRef.child("account1").get().addOnSuccessListener {
                type = it.child("plan").value.toString()
                basicClassNumber = Integer.parseInt(it.child("BasicClassCount").value.toString())
            }.addOnFailureListener{
                //Log.e("firebase", "Error getting data", it)
            }

            if(type=="Basic"){
                maximumBasisClass = 5;
                if(basicClassNumber < maximumBasisClass){
                    myRef.child("account1").child("Basic").child(className).setValue(basicClass)
                    myRef.child("account1").child("BasisClassCount").setValue(basicClassNumber+1)
                    //Navigation.findNavController(root).navigate(R.id.action_nav_profile_to_editProfile2)
                }else{
                    Toast.makeText(context,"Maximum Classes Created.",Toast.LENGTH_SHORT).show()
                }
            }else if(type=="Premium"){
                myRef.child("account1").child("Basic").child(className).setValue(basicClass)
                myRef.child("account1").child("BasisClassCount").setValue(basicClassNumber+1)
                //Navigation.findNavController(root).navigate(R.id.action_nav_profile_to_editProfile2)
            }

        }


        return binding.root
    }

}