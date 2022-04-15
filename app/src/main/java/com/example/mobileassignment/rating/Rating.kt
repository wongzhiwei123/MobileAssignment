package com.example.mobileassignment.rating

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import com.example.mobileassignment.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Rating.newInstance] factory method to
 * create an instance of this fragment.
 */
class Rating : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var ratingBar: RatingBar
    private lateinit var submit : Button
    private lateinit var cancel : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            ratingBar.findViewById(R.id.ratingBar) as RatingBar
            submit.findViewById(R.id.btnRating) as Button
            cancel.findViewById(R.id.btnCancelRating) as Button

            submit.setOnClickListener(View.OnClickListener {
                Toast.makeText(context,"Your rating is " + ratingBar.rating, Toast.LENGTH_SHORT).show()
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rating, container, false)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Rating.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Rating().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}