package com.example.mobileassignment.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R

class TaskAdapter(private val taskList : ArrayList<Task>) : RecyclerView.Adapter<TaskAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_item,
        parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = taskList[position]

        holder.train.text = currentItem.train
        holder.description.text = currentItem.description
        holder.set.text = currentItem.set
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val train : TextView = itemView.findViewById(R.id.tvTraining)
        val description : TextView = itemView.findViewById(R.id.tvDescription)
        val set : TextView = itemView.findViewById(R.id.tvSet)



    }
}