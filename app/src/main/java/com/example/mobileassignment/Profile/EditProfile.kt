package com.example.mobileassignment.Profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.mobileassignment.R
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class EditProfile : Fragment() {

    //private val sharedPrefFile = "kotlinsharedpreference"

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
        val database = Firebase.database("https://findyourcoach-3083a-default-rtdb.asia-southeast1.firebasedatabase.app/")
        val myRef = database.getReference("user")

//        var phone : EditText= view.findViewById(R.id.displayPhoneNo)
//        val height : EditText= view.findViewById(R.id.displayHeight)
//        val weight : EditText = view.findViewById(R.id.displayWeight)
//        val bio : EditText = view.findViewById(R.id.displayAboutMe)


        myRef.child("account1").child("details").get().addOnSuccessListener {


//            phone.text = it.child("phone").value.toString()
//            phone.setText(it.child("phone").value.toString(), TextView.BufferType.EDITABLE)
//            height.text = it.child("height").value.toString()
//            weight.text = it.child("weight").value.toString()
//            bio.text = it.child("bio").value.toString()
        }

        myRef.child("account1").child("details")


        val save: Button = view.findViewById(R.id.confirmEditButton)
        save.setOnClickListener{
            val editPhoneNo : EditText = view.findViewById(R.id.editPhone)
            val phone = editPhoneNo.text.toString()
            val editH : EditText = view.findViewById(R.id.editHeight)
            val height = editH.text.toString()
            val editW : EditText= view.findViewById(R.id.editWeight)
            val weightD = editW.text.toString()
            val editB : EditText = view.findViewById(R.id.editBio)
            val bio = editB.text.toString()
            val editPass : EditText = view.findViewById(R.id.editPassword)
            val editP = editPass.text.toString()
            val conEditPass : EditText = view.findViewById(R.id.confirmEditPassword)
            val conP = conEditPass.text.toString()

            myRef.child("account1").child("details").child("phone").setValue(phone)
            myRef.child("account1").child("details").child("height").setValue(height)
            myRef.child("account1").child("details").child("weight").setValue(weightD)
            myRef.child("account1").child("details").child("bio").setValue(bio)

            if(editP != null && conP != null){
                if(editP == conP){
                    myRef.child("account1").child("details").child("password").setValue(editP)
                }
                else{
                    Toast.makeText(context,"Passcode is not updated as the passcode is not the same", Toast.LENGTH_SHORT).show()
                }
            }

            Navigation.findNavController(view).navigate(R.id.action_nav_editProfile_to_nav_profile)
        }
        return view
    }
}