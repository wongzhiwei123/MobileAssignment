package com.example.mobileassignment.Class

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R
import com.google.firebase.database.*


class PremiumDetails : Fragment(){

    private lateinit var recyclerViewStudent: RecyclerView
    private lateinit var database: DatabaseReference
    private lateinit var premiumStudentArrayList: ArrayList<PremiumStudent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_premium_details, container, false)

        recyclerViewStudent = view.findViewById(R.id.rvPremiumStudent)
        recyclerViewStudent.layoutManager = LinearLayoutManager(context)
        recyclerViewStudent.setHasFixedSize(true)

        premiumStudentArrayList = arrayListOf<PremiumStudent>()
        getPremiumStudent()

        return view
    }

    private fun getPremiumStudent() {
        database = FirebaseDatabase.getInstance().getReference("user")

        database.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot1: DataSnapshot){
                if(snapshot1.exists()){
                    for(basicClassSnapshot in snapshot1.children){
                        val premiumStudent = basicClassSnapshot.getValue(PremiumStudent::class.java)
                        premiumStudentArrayList.add(premiumStudent!!)
                    }
                    recyclerViewStudent.adapter = PremiumStudentAdapter(premiumStudentArrayList)
                }
            }
            override fun onCancelled(error: DatabaseError){

            }
        })
    }
        //database = FirebaseDatabase.getInstance().reference
        //recyclerViewStudent = view.findViewById(R.id.rvPremiumStudent)


//        recyclerView = view.findViewById(R.id.rvPremiumStudent);
//        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
//        FirebaseRecyclerOptions<model> options = new FirebaseRecyclerOptions.Builder<model>().setQuery(quer,model.class).build();
////        mDatabase = FirebaseDatabase.getInstance();
////        mRef = mDatabase.getReference().child("Student");
////        mStorage = FirebaseStorage.getInstance();
////        recyclerView = view.findViewById(R.id.recycleview_id);
////        recyclerView.setHasFixedSize(true);
////        recyclerView.layoutManager = new LinearLayoutManager(this);
////


}