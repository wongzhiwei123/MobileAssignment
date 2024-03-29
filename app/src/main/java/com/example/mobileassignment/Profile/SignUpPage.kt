package com.example.mobileassignment.Profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mobileassignment.R
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignUpPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        val database = Firebase.database("https://findyourcoach-3083a-default-rtdb.asia-southeast1.firebasedatabase.app/")
        val myRef = database.getReference("user")

        val signUp: Button = findViewById(R.id.signUpButton);
        signUp.setOnClickListener {

            val name : EditText = findViewById(R.id.userNameEnter)
            val userName = name.text.toString()
            val email : EditText = findViewById(R.id.enterEmail)
            val userEmail = email.text.toString()
            val phone : EditText = findViewById(R.id.enterPhoneNumber)
            val userPhone = phone.text.toString()
            val height : EditText = findViewById(R.id.enterHeight)
            val userHeight = height.text.toString()
            val weight : EditText = findViewById(R.id.enterWeight)
            val userWeight = weight.text.toString()
            val pass : EditText = findViewById(R.id.editTextTextPassword)
            val userPass = pass.text.toString()
            val conPass : EditText = findViewById(R.id.confirmUserPass)
            val conP = conPass.text.toString()

            //myRef.child(userEmail.toString()).child("details").child("name").setValue(userName)
            myRef.child("account2").child("details").setValue("")
            myRef.child("account2").child("details").child("name").setValue(userName)
            myRef.child("account2").child("details").child("email").setValue(userEmail)
            myRef.child("account2").child("details").child("phone").setValue(userPhone)
            myRef.child("account2").child("details").child("height").setValue(userHeight)
            myRef.child("account2").child("details").child("weight").setValue(userWeight)
            myRef.child("account2").child("details").child("bio").setValue("")

            if(userPass != null && conP != null){
                if(userPass== conP){
                    myRef.child("account2").child("details").child("password").setValue(userPass)
                }
                else{
                    Toast.makeText(this,"Passcode is not updated as the passcode is not the same", Toast.LENGTH_SHORT).show()
                }
            }

            Toast.makeText(this, "Registered.", Toast.LENGTH_LONG).show()
            finish()
        }

        val signIn: Button = findViewById(R.id.alrMember);
        signIn.setOnClickListener {
            finish()
        }
    }
}