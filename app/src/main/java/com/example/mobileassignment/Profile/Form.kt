package com.example.mobileassignment.Profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import com.example.mobileassignment.R
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Form : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val database = Firebase.database("https://findyourcoach-3083a-default-rtdb.asia-southeast1.firebasedatabase.app/")
        val myRef = database.getReference("user")
        myRef.child("account1").child("details")

        val submit: Button = findViewById(R.id.submitCert)
        submit.setOnClickListener {
            val job: Int = findViewById<Spinner>(R.id.jobSpinner).selectedItemPosition
            var selectJob = ""
            if(job == 0){
                selectJob = "Badminton"
            }
            else if(job == 1){
                selectJob = "Basketball"
            }
            else if(job == 2){
                selectJob = "Swimming"
            }
            else if(job == 3){
                selectJob = "GYM"
            }
            myRef.child("account1").child("details").child("cert").setValue(selectJob)

            val year: Int = findViewById<Spinner>(R.id.yearSpinner).selectedItemPosition
            var selectYear = ""

            if(year == 0){
                selectYear = "1-2"
            }
            else if(year == 1){
                selectYear = "3-4"
            }
            else if(year == 2){
                selectYear = "More than 4"
            }
            myRef.child("account1").child("details").child("cert").setValue(selectYear)
        }

    }
}