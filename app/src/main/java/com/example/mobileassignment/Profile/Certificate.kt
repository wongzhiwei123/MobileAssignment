package com.example.mobileassignment.Profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobileassignment.R

class Certificate : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit_profile, container, false)

//        val database = Firebase.database("https://findyourcoach-3083a-default-rtdb.asia-southeast1.firebasedatabase.app/")
//        val myRef = database.getReference("user")
//        myRef.child("account1").child("details")
//
//        val submit: Button = view.findViewById(R.id.submitCert)
//        submit.setOnClickListener {
//            val job: Int = view.findViewById<Spinner>(R.id.jobSpinner).selectedItemPosition
//            var selectJob = ""
//            if(job == 0){
//                selectJob = "Badminton"
//            }
//            else if(job == 1){
//                selectJob = "Basketball"
//            }
//            else if(job == 2){
//                selectJob = "Swimming"
//            }
//            else if(job == 3){
//                selectJob = "GYM"
//            }
//            myRef.child("account1").child("details").child("cert").setValue(selectJob)
//
//            val year: Int = view.findViewById<Spinner>(R.id.yearSpinner).selectedItemPosition
//            var selectYear = ""
//
//            if(year == 0){
//                selectYear = "1-2"
//            }
//            else if(year == 1){
//                selectYear = "3-4"
//            }
//            else if(year == 2){
//                selectYear = "More than 4"
//            }
//            myRef.child("account1").child("details").child("cert").setValue(selectYear)
//        }
//

        return view
    }

}