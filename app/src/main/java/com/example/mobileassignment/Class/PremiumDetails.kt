package com.example.mobileassignment.Class

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

class PremiumDetails : Fragment() {

    private lateinit var mDatabase:FirebaseDatabase;
    private lateinit var recyclerView: RecyclerView;
    private lateinit var mRef: DatabaseReference;
    private lateinit var mStorage: FirebaseStorage;
//    private lateinit var studentAdapter: StudentAdapter;
//    private lateinit var studentModelList:List<Student>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_premium_details, container, false)
//        mDatabase = FirebaseDatabase.getInstance();
//        mRef = mDatabase.getReference().child("Student");
//        mStorage = FirebaseStorage.getInstance();
//        recyclerView = view.findViewById(R.id.recycleview_id);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.layoutManager = new LinearLayoutManager(this);
//
        return view
    }


}