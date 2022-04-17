package com.example.mobileassignment.Class

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R

class PremiumStudentAdapter(private val context: Context, private val premiumStudentList: List<PremiumStudent>): RecyclerView.Adapter<MyViewHolder>(){

    override fun getItemCount(): Int {
        return premiumStudentList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_premium_details,parent,false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val student = premiumStudentList[position]
        holder.userName.text = student.userName
        holder.trainingDate.text = student.trainingDate
        holder.trainingTime.text = student.trainingTime

        if(student.imageUri != null){
            holder.imageUri.setImageURI(student.imageUri)
        }
        //Glide.with(context).load(student.imageUri).into(holder.imageUri)
    }
}

class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val userName: TextView = itemView.findViewById(R.id.txtStudentName)
    val trainingDate: TextView = itemView.findViewById(R.id.txtStudentTrainingDate)
    val trainingTime: TextView = itemView.findViewById(R.id.txtStudentTrainingTime)
    val imageUri: ImageView = itemView.findViewById(R.id.imgClass)
}