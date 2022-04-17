package com.example.mobileassignment.Class

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class BasicClassDetails : Fragment() {

    private lateinit var database : DatabaseReference
    private lateinit var recyclerViewBasic: RecyclerView
    private lateinit var classArrayList: ArrayList<BasicClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_basic_class_details, container, false)

        recyclerViewBasic = view.findViewById(R.id.rvBasicClass)
        recyclerViewBasic.layoutManager = LinearLayoutManager(context)
        recyclerViewBasic.setHasFixedSize(true)

        classArrayList = arrayListOf<BasicClass>()
        getBasicClass()

        return view
    }

    private fun getBasicClass() {
        database = FirebaseDatabase.getInstance().getReference("class")

        database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                classArrayList.clear()
                if(snapshot.exists()){
                    for (classSnap in snapshot.children){
                        val bClass = classSnap.getValue(BasicClass::class.java)
                        classArrayList.add(bClass!!)
                    }
                    val mAdapter = BasicClassAdapter(classArrayList)
                    recyclerViewBasic.adapter = mAdapter;
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


}