package com.example.mobileassignment.task

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R
import com.google.firebase.database.*


class tasklist : Fragment() {

    private lateinit var dbref : DatabaseReference
    private lateinit var taskRecyclerView: RecyclerView
    private lateinit var taskArrayList: ArrayList<Task>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {



        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_tasklist, container, false)

        taskRecyclerView = view.findViewById(R.id.recyclerTask)
        taskRecyclerView.layoutManager = LinearLayoutManager(context)
        taskRecyclerView.setHasFixedSize(true)

        taskArrayList = arrayListOf<Task>()
        getTaskData()
        return view
    }

    private fun getTaskData() {
        dbref = FirebaseDatabase.getInstance().getReference("TaskList")

        dbref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {

                    for (taskSnapshot in snapshot.children) {

                        val task = taskSnapshot.getValue(Task::class.java)
                        taskArrayList.add(task!!)
                    }
                    taskRecyclerView.adapter = TaskAdapter(taskArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}