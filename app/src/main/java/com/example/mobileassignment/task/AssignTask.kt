package com.example.mobileassignment.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.mobileassignment.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AssignTask : Fragment() {

    private lateinit var training : EditText
    private lateinit var desc : EditText
    private lateinit var set : EditText
    private lateinit var dbref : DatabaseReference
    private lateinit var confirm : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_assign_task, container, false)

        confirm = view.findViewById(R.id.btnUpload)
        training = view.findViewById(R.id.editTraining)
        desc = view.findViewById(R.id.editDesc)
        set = view.findViewById(R.id.editSet)

        confirm.setOnClickListener{
            val train = training.text.toString()
            val des = desc.text.toString()
            val sets = set.text.toString()

            dbref = FirebaseDatabase.getInstance().getReference("TaskList")
            val Task = Task(train,des,sets)
                dbref.child(train).setValue(Task).addOnSuccessListener {
                training.text.clear()
                desc.text.clear()
                set.text.clear()
                    Navigation.findNavController(view).navigate(R.id.action_nav_assignTask_to_tasklist)

                Toast.makeText(context, "Successfully uploaded", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                    Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
                }
        }

    return view

    }

}