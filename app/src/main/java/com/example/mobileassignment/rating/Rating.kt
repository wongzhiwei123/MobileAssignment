package com.example.mobileassignment.rating

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import com.example.mobileassignment.R

class Rating : Fragment() {

private lateinit var ratingBar: RatingBar
private lateinit var rate : Button
private lateinit var cancel : Button

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

        ratingBar.setOnRatingBarChangeListener { ratingBar, fl, b ->

            Toast.makeText(requireContext(),"Rating: " + ratingBar.rating,Toast.LENGTH_LONG).show()
        }

        rate.setOnClickListener{
            Toast.makeText(requireActivity(),"Your rating is =" + ratingBar.rating,Toast.LENGTH_LONG).show()

        }
        return view
    }

}