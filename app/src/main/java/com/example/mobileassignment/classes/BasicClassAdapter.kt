package com.example.mobileassignment.classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R

class BasicClassAdapter(private val basicClassList : ArrayList<BasicClass>) : RecyclerView.Adapter<BasicClassAdapter.BasicClassViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicClassViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.basic_class_details,
            parent,false)
        return BasicClassViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BasicClassViewHolder, position: Int) {
        val currentClass = basicClassList[position]

        holder.basicClassName.text = currentClass.basicClassName
        holder.basicTrainingDay.text = currentClass.basicTrainingDay
        holder.basicTrainingTime.text = currentClass.basicTrainingTime
        holder.basicDescription.text = currentClass.basicDescription
    }

    override fun getItemCount(): Int {
        return basicClassList.size
    }

    class BasicClassViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val basicClassName: TextView = itemView.findViewById(R.id.txtBasicClass)
        val basicTrainingDay: TextView = itemView.findViewById(R.id.txtBasicTrainingDay)
        val basicTrainingTime: TextView = itemView.findViewById(R.id.txtBasicTrainingTime)
        val basicDescription: TextView = itemView.findViewById(R.id.txtBasicDescription)
    }
}