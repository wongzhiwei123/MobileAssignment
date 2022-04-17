package com.example.mobileassignment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {

    //val sharedPref: SharedPreferences = requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        //val emailAddress = sharedPref.getString("emailAddress", "")
        // Read from the database
        val database = Firebase.database("https://findyourcoach-3083a-default-rtdb.asia-southeast1.firebasedatabase.app/")
        val myRef = database.getReference("user")
        val name : TextView = view.findViewById(R.id.userNameDisplay)
        val phone : TextView = view.findViewById(R.id.displayPhoneNo)
        val email : TextView = view.findViewById(R.id.displayEmail)
        val height : TextView = view.findViewById(R.id.displayHeight)
        val weight : TextView = view.findViewById(R.id.displayWeight)
        val bio : TextView = view.findViewById(R.id.displayAboutMe)

        myRef.child("account1").child("details").get().addOnSuccessListener {

            name.text = it.child("name").value.toString()
            phone.text = it.child("phone").value.toString()
            email.text = it.child("email").value.toString()
            height.text = it.child("height").value.toString()
            weight.text = it.child("weight").value.toString()
            bio.text = it.child("bio").value.toString()
        }
//
//        myRef.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                val value = dataSnapshot.getValue()
//                Log.d(TAG, "Value is: $value")
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException())
//            }
//
//
//        })

        val gotoEdit: Button = view.findViewById(R.id.editProfile)
        gotoEdit.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_nav_profile_to_editProfile)
        }


        val signout: Button = view.findViewById(R.id.buttonSignOut) //cannot in edit
        signout.setOnClickListener{

            (activity as? LoginActivity)?.let{
                val intent = Intent (it, LoginActivity::class.java)
                it.startActivity(intent)
            }

            //supportFragmentManager.beginTransaction().replace(R.id.mainContainer, LoginActivity()).commit()
        }

        return view
    }

}