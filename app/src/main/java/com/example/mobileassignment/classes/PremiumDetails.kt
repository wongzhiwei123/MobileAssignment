package com.example.mobileassignment.classes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R
import com.example.mobileassignment.databinding.FragmentCreateBasicClassBinding
import com.example.mobileassignment.databinding.FragmentPremiumDetailsBinding
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_premium_details.view.*


class PremiumDetails : Fragment(){

    private lateinit var binding:FragmentPremiumDetailsBinding
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
        binding = FragmentPremiumDetailsBinding.inflate(inflater, container, false)
       val root = binding.root
        //val view = inflater.inflate(R.layout.fragment_premium_details, container, false)


        //recyclerViewStudent = view.findViewById(R.id.rvPremiumStudent)
        binding.rvPremiumStudent.layoutManager = LinearLayoutManager(context)
        binding.rvPremiumStudent.setHasFixedSize(true)

        premiumStudentArrayList = arrayListOf<PremiumStudent>()
        getPremiumStudent()

        return root
    }

    private fun getPremiumStudent() {
        database = FirebaseDatabase.getInstance().getReference("premium")

        database.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot){
                if(snapshot.exists()){
                    for(premiumSnap in snapshot.children){
                        val pStudent = premiumSnap.getValue(PremiumStudent::class.java)
                        premiumStudentArrayList.add(pStudent!!)
                    }
                    binding.rvPremiumStudent.adapter = PremiumStudentAdapter(premiumStudentArrayList)
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