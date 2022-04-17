package com.example.mobileassignment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mobileassignment.Profile.ForgetPassword
import com.example.mobileassignment.Profile.SignUpPage
//import com.example.mobileassignment.profile.SignUp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        auth = FirebaseAuth.getInstance()
//
//        val currentuser = auth.currentUser
//        if(currentuser != null) {
//            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
//            finish()
//        }


        val database = Firebase.database("https://findyourcoach-3083a-default-rtdb.asia-southeast1.firebasedatabase.app/")
        val myRef = database.getReference("user")
        val sharedPref = getSharedPreferences("login", Context.MODE_PRIVATE)
        var edit = sharedPref.edit()

        //val view = inflater.inflate(R.layout.fragment_login_page, container, false)
        val signIn: Button = findViewById(R.id.loginButton)
        signIn.setOnClickListener{

            val email: EditText = findViewById(R.id.enterUserEmail)
            val pass: EditText = findViewById(R.id.enterPassword)
            val mail = email.text.toString()
            val passcode = pass.text.toString()
            var readMail = ""
            var readPass = "abc"

            edit.apply{
                putString("emailAddress", mail)
//                putString("name", snapshot.child("name").value.toString())
//                putString("password", snapshot.child("password").value.toString())
//                putString("phoneNo", snapshot.child("phoneNo").value.toString())
//                putString("profilePicPath", snapshot.child("profilePicPath").value.toString())
            }.apply()


            myRef.child("account1").child("details").get().addOnSuccessListener { //email empty can in, cannot session, navigation to forget
                 readMail = it.child("email").value.toString()
                 readPass = it.child("password").value.toString()
                if(mail != null){
                    if(passcode == readPass){
                        startActivity(Intent(this, MainActivity::class.java))
                        startActivity(intent)
                        Toast.makeText(this, "Login In", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
                }
            }

//            if(TextUtils.isEmpty(enterUserEmail.text.toString())){
//                enterUserEmail.setError("Please enter your email")
//                return@setOnClickListener
//            }
//            else if(TextUtils.isEmpty(enterPassword.text.toString())){
//                enterPassword.setError("Please enter your password")
//                return@setOnClickListener
//            }
//            auth.signInWithEmailAndPassword(enterUserEmail.text.toString(), enterPassword.text.toString())
//                .addOnCompleteListener {
//                    if(it.isSuccessful) {
//                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
//                        finish()
//                    } else {
//                        Toast.makeText(this@LoginActivity, "Login failed, please try again! ", Toast.LENGTH_LONG).show()
//                    }
//                }


            //authentication(email.text.toString(), pass.text.toString())

        }
        val login : ConstraintLayout = findViewById(R.id.loginFrame)
        val forget: Button = findViewById(R.id.forgetPass);
        forget.setOnClickListener {
            startActivity(Intent(this, ForgetPassword::class.java))
            startActivity(intent)


            //supportFragmentManager.beginTransaction().add(R.id.container, ForgetPass()).commit()
            //login.visibility = View.GONE
//            val pendingIntent = NavDeepLinkBuilder(this.applicationContext)
//                .setComponentName(LoginActivity::class.java)
//                .setGraph(R.navigation.nav_graph)
//                .setDestination(R.id.forgetPassword)
//                .setArguments(savedInstanceState)
//                .createPendingIntent()

            //notificationBuilder.setContentIntent(pendingIntent)
            //pendingIntent.send()
        }
//            val intent = Intent(this, fragment_forget_pass::class.java)
//            startActivity(intent)
//        }
//
       // val signup: Button = findViewById(R.id.signUp)
//        signup.setOnClickListener{
//            supportFragmentManager.beginTransaction().add(R.id.container, SignUp()).commit()
//        }

        val signUp: Button = findViewById(R.id.signUp);
        signUp.setOnClickListener {
            startActivity(Intent(this, SignUpPage::class.java))
            startActivity(intent)
        }

        //return view
    }
       private fun authentication(mail:String, passcode: String){




       }
}