package com.example.mobileassignment.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mobileassignment.LoginActivity
import com.example.mobileassignment.R
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ForgetPassword : AppCompatActivity() {

    val database = Firebase.database("https://findyourcoach-3083a-default-rtdb.asia-southeast1.firebasedatabase.app/")
    val myRef = database.getReference("user")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        val Verify: Button = findViewById(R.id.verifyButton);
        Verify.setOnClickListener {

            val nPass : EditText = findViewById(R.id.newPass)
            val pass = nPass.text.toString()
            val conPass : EditText = findViewById(R.id.confrimNewPass)
            val conP = conPass.text.toString()

            if(pass != null && conP != null){
                if(pass == conP){
                    myRef.child("account1").child("details").child("password").setValue(pass)
                }
                else{
                    Toast.makeText(this,"Passcode is not updated as the passcode is not the same", Toast.LENGTH_SHORT).show()
                }
            }

            finish()
            Toast.makeText(this, "Successfully Change. ", Toast.LENGTH_LONG).show()
        }

        val back: Button = findViewById(R.id.backToLogin1);
        back.setOnClickListener {
            finish()
        }
    }
}