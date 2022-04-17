package com.example.mobileassignment.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileassignment.R;

import java.util.ArrayList;

public class PremiumStudentAdapter1 extends RecyclerView.Adapter<PremiumStudentAdapter1.MyViewHolder> {

    Context context;
    ArrayList<PremiumStudent> premiumStudentsList;

    public PremiumStudentAdapter1(Context context, ArrayList<PremiumStudent> premiumStudentsList) {
        this.context = context;
        this.premiumStudentsList = premiumStudentsList;
    }

    @NonNull
    @Override
    public PremiumStudentAdapter1.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.premium_student_details,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PremiumStudentAdapter1.MyViewHolder holder, int position) {
        PremiumStudent premiumStudent = premiumStudentsList.get(position);
        holder.userName.setText(premiumStudent.getUserName());
        //holder.trainingDate.setText(premiumStudent.getTrainingDate);
        holder.trainingTime.setText(premiumStudent.getTrainingTime());
    }

    @Override
    public int getItemCount() {
        return premiumStudentsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView userName, trainingDate, trainingTime;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            userName = itemView.findViewById(R.id.txtBasicClass);
            trainingDate = itemView.findViewById(R.id.txtBasicTrainingDay);
            trainingTime = itemView.findViewById(R.id.txtBasicTrainingTime);
        }
    }
}
