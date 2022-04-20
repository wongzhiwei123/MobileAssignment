package com.example.mobileassignment.classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R

class PremiumStudentAdapter(private val premiumStudentList: ArrayList<PremiumStudent>): RecyclerView.Adapter<PremiumStudentAdapter.PremiumStudentViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PremiumStudentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.premium_student_details,
            parent,false)
        return PremiumStudentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PremiumStudentViewHolder, position: Int) {
        val currentStudent = premiumStudentList[position]

        holder.studentName.text = currentStudent.studentName
        holder.trainingDate.text = currentStudent.trainingDate
        holder.trainingTime.text = currentStudent.trainingTime

//        if(student.imageUri != null){
//            holder.imageUri.setImageURI(student.imageUri)
//        }
    }

    override fun getItemCount(): Int {
        return premiumStudentList.size
    }

    class PremiumStudentViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val studentName: TextView = itemView.findViewById(R.id.txtStudentName)
        val trainingDate: TextView = itemView.findViewById(R.id.txtStudentTrainingDate)
        val trainingTime: TextView = itemView.findViewById(R.id.txtStudentTrainingTime)
        //val imageUri: ImageView = itemView.findViewById(R.id.imgClass)
    }
}

