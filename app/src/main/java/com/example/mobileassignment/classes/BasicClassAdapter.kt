package com.example.mobileassignment.classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R

class BasicClassAdapter(private val basicClassList: ArrayList<BasicClass>): RecyclerView.Adapter<BasicClassAdapter.BasicClassViewHolder>(){
    override fun getItemCount(): Int {
        return basicClassList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicClassViewHolder {
//        return BasicClassViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.fragment_basic_class_details,parent,false)
//        )
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.basic_class_details,parent,false)
        return BasicClassViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BasicClassViewHolder, position: Int) {
        val currentItem = basicClassList[position]
        holder.basicClassName.text = currentItem.basicClassName
        holder.basicTrainingDay.text = currentItem.basicTrainingDay
        holder.basicTrainingTime.text = currentItem.basicTrainingTime
        holder.basicDescription.text = currentItem.basicDescription
    }
    class BasicClassViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val basicClassName: TextView = itemView.findViewById(R.id.txtBasicClass)
        val basicTrainingDay: TextView = itemView.findViewById(R.id.txtBasicTrainingDay)
        val basicTrainingTime: TextView = itemView.findViewById(R.id.txtBasicTrainingTime)
        val basicDescription: TextView = itemView.findViewById(R.id.txtBasicDescription)
        //val imageClass: ImageView = itemView.findViewById(R.id.imgClass)
    }
}