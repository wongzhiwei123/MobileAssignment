package com.example.mobileassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.mobileassignment.R


class ProfileFragment : Fragment() {


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
        val gotoEdit: Button = view.findViewById(R.id.editProfile)
        gotoEdit.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_nav_profile_to_editProfile2)
        }
        return view
    }


}