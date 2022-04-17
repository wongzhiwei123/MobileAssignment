package com.example.mobileassignment.Class

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.mobileassignment.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddBasicClass : Fragment(R.layout.fragment_add_basis_class) {

    private lateinit var database : DatabaseReference;
    //private lateinit var storage : StorageReference

    private lateinit var btnCreate : Button;
    private lateinit var className : EditText;
    private lateinit var trainingDay : EditText;
    private lateinit var trainingTime : EditText;
    private lateinit var description : EditText;
    private lateinit var userName : String;

    //private lateinit var _binding : FragmentAddBasicClass.inflate(inflater,container,false)
    //private lateinit var image1 : ImageButton;


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_basis_class, container, false)

        database = FirebaseDatabase.getInstance().reference
        //storage = FirebaseStorage.getInstance().reference

        btnCreate = view.findViewById(R.id.btnCreate)

        btnCreate.setOnClickListener(){
            val className = view.findViewById<EditText>(R.id.edtxtclassName).toString()
            val trainingDay = view.findViewById<Spinner>(R.id.spinnerDay).selectedItem.toString()
            val trainingTime = view.findViewById<Spinner>(R.id.spinnerTime).selectedItem.toString()
            val description = view.findViewById<EditText>(R.id.edtxtDescription).toString()
            //val imageClass = view.findViewById<ImageView>(R.id.imgClass).setImageURI()

            val BasicClass = BasicClass(className,trainingDay,trainingTime,description)
            database.child("basicClass").setValue(BasicClass).addOnSuccessListener {
                //Clear
                Toast.makeText(requireContext(),"Successfully Created",Toast.LENGTH_SHORT).show()
            }
                .addOnFailureListener{
                    Toast.makeText(requireContext(),"Failed to create class",Toast.LENGTH_SHORT).show()
                }
        }

        val imgBtn = view.findViewById<ImageButton>(R.id.imgAddClass)
        imgBtn.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent,0)
        }



        return view
    }

//    var selectedPhotoUri: Uri? = null
//    private var resolver = requireActivity().contentResolver
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode == 0 && resultCode == Activity.RESULT_OK && data!=null){
//            val imgBtn = view?.findViewById<ImageButton>(R.id.imgBtn)
//            selectedPhotoUri = data.data
//            val bitmap = MediaStore.Images.Media.getBitmap(resolver, selectedPhotoUri)
//
//            val bitmapDrawable = BitmapDrawable(bitmap)
//            imgBtn?.setBackgroundDrawable(bitmapDrawable)
//        }
//    }


}