package com.example.mobileassignment.Class

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.MultiAutoCompleteTextView
import com.example.mobileassignment.R

class AddBasisClass : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_basis_class, container, false)
//        val mtv1 = view.findViewById<MultiAutoCompleteTextView>(R.id.mtvTrainingDay)
//        val trainDays = arrayOf("Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday")
//        val adapter1 = ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1,trainDays)
//        mtv1.setAdapter(adapter1)
//        mtv1.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        val imgBtn = view.findViewById<ImageButton>(R.id.imgBtn)
        imgBtn.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent,0)
        }



        return view
    }

//    var selectedPhotoUri: Uri? = null
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode == 0 && resultCode == Activity.RESULT_OK && data!=null){
//            selectedPhotoUri = data.data
//            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
//
//            val bitmapDrawable = BitmapDrawable(bitmap)
//            imgBtn.setBackgroundDrawable(bitmapDrawable)
//        }
//    }


}