package com.example.mobileassignment.classes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R
import com.example.mobileassignment.databinding.FragmentBasicClassDetailsBinding
import com.example.mobileassignment.databinding.FragmentBasicClassInfoBinding
import com.google.firebase.database.*


class BasicClassDetails : Fragment() {

    private lateinit var database : DatabaseReference
    private lateinit var recyclerViewBasic: RecyclerView
    private lateinit var classArrayList: ArrayList<BasicClass>
    private lateinit var binding:FragmentBasicClassDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBasicClassDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        recyclerViewBasic = binding.rvBasicClass
        recyclerViewBasic.layoutManager = LinearLayoutManager(context)
        recyclerViewBasic.setHasFixedSize(true)

        classArrayList = arrayListOf<BasicClass>()
        getBasicClass()

        binding.btnCreateClass.setOnClickListener{

        }

        return binding.root
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