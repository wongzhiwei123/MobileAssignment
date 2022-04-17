package com.example.mobileassignment.rating

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation
import com.example.mobileassignment.R
import com.example.mobileassignment.task.Task
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Rating : Fragment() {

private lateinit var ratingBar: RatingBar
private lateinit var rate : Button
private lateinit var cancel : Button
private lateinit var text: TextView
private lateinit var dbref : DatabaseReference
private lateinit var comment : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_rating, container, false)

        ratingBar = view.findViewById(R.id.ratingBar)
        rate = view.findViewById(R.id.btnRating)
        cancel = view.findViewById(R.id.btnCancelRating)
        text = view.findViewById(R.id.txtDisatisfied)
        comment = view.findViewById(R.id.txtComment)

        ratingBar.setOnRatingBarChangeListener { ratingBar, fl, b ->
            text.setText("Rating = $fl")
        }

        rate.setOnClickListener{
            val rb = ratingBar.rating
            val cm = comment.text.toString()

            dbref = FirebaseDatabase.getInstance().getReference("Rating")
            val Rate = Rate(rb,cm)
            dbref.child(cm).setValue(Rate).addOnSuccessListener {



                Toast.makeText(context, "Successfully rated", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
            }

        }

        return view
    }

}