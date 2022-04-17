package com.example.mobileassignment.Class

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class PremiumDetails : Fragment(){

    private lateinit var recyclerViewStudent: RecyclerView
    private lateinit var database: DatabaseReference

//    private lateinit var mDatabase:FirebaseDatabase;
//    private lateinit var recyclerView: RecyclerView;
//    private lateinit var mRef: DatabaseReference;
//    private lateinit var mStorage: FirebaseStorage;
////    private lateinit var studentAdapter: StudentAdapter;
////    private lateinit var studentModelList:List<Student>;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_premium_details, container, false)

        database = FirebaseDatabase.getInstance().reference
        recyclerViewStudent = view.findViewById(R.id.rvPremiumStudent)


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
        return view
    }

    class My

}