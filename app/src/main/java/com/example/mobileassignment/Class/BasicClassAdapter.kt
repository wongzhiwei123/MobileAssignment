package com.example.mobileassignment.Class

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R

class BasicClassAdapter(private val basicClassList: List<BasicClass>): RecyclerView.Adapter<BasicClassViewHolder>(){
    override fun getItemCount(): Int {
        return basicClassList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicClassViewHolder {
        return BasicClassViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_basic_class_details,parent,false)
        )
    }

    override fun onBindViewHolder(holder: BasicClassViewHolder, position: Int) {
        val basicClass = basicClassList[position]
        holder.basicClassName.text = basicClass.basicClassName
        holder.basicTrainingDay.text = basicClass.basicTrainingDay
        holder.basicTrainingTime.text = basicClass.basicTrainingTime
        holder.basicDescription.text = basicClass.basicDescription

//        if(basicClass.imageClass != null){
//            holder.imageClass.setImageURI(basicClass.imageClass)
//        }
    }
}

class BasicClassViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val basicClassName: TextView = itemView.findViewById(R.id.txtBasicClass)
    val basicTrainingDay: TextView = itemView.findViewById(R.id.txtBasicTrainingDay)
    val basicTrainingTime: TextView = itemView.findViewById(R.id.txtBasicTrainingTime)
    val basicDescription: TextView = itemView.findViewById(R.id.txtBasicDescription)
    //val imageClass: ImageView = itemView.findViewById(R.id.imgClass)
}