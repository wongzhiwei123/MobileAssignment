package com.example.mobileassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.Navigation

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //val view = inflater.inflate(R.layout.fragment_login_page, container, false)
        val signIn: Button = findViewById(R.id.loginButton)
        signIn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

//        val forget: Button = findViewById(R.id.forgetPass)
//        forget.setOnClickListener{
//            val intent = Intent(this, frag::class.java)
//            startActivity(intent)
//        }
//
//        val signup: Button = findViewById(R.id.signUp)
//        signup.setOnClickListener{
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }

        //return view
    }
}