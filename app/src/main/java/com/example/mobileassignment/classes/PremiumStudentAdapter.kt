package com.example.mobileassignment.classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R

class PremiumStudentAdapter(private val premiumStudentList: ArrayList<PremiumStudent>): RecyclerView.Adapter<PremiumStudentAdapter.PremiumStudentViewHolder>(){

    override fun getItemCount(): Int {
        return premiumStudentList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PremiumStudentViewHolder {
//        return PremiumStudentViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.fragment_premium_details,parent,false)
//        )
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.premium_student_details,parent,false)
        return PremiumStudentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PremiumStudentViewHolder, position: Int) {
        val student = premiumStudentList[position]
        holder.userName.text = student.userName
        holder.trainingDate.text = student.trainingDate
        holder.trainingTime.text = student.trainingTime

//        if(student.imageUri != null){
//            holder.imageUri.setImageURI(student.imageUri)
//        }
    }
    class PremiumStudentViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val userName: TextView = itemView.findViewById(R.id.txtStudentName)
        val trainingDate: TextView = itemView.findViewById(R.id.txtStudentTrainingDate)
        val trainingTime: TextView = itemView.findViewById(R.id.txtStudentTrainingTime)
        //val imageUri: ImageView = itemView.findViewById(R.id.imgClass)
    }
}

