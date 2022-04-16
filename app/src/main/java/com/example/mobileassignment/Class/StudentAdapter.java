package com.example.mobileassignment.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileassignment.R;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    Context context;
    List<Student> studentList;


    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_premium_details,false)
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Student studentModel = studentList.get(position);
       holder.userName.setText(studentModel.getUserName());
       holder.phoneNumber.setText(studentModel.getPhoneNumber());
       holder.bookingTime.setText(studentModel.getBookingDate());
       holder.userName.setText(studentModel.getBookingTime());

       String imageURL = null;
       imageURL = studentModel.getImage();
       Picasso.get().load(imageURL).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView userName, phoneNumber, bookingDate, bookingTime;
        public ViewHolder(@NonNull View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.);
            userName = itemView.findViewById(R.id.txtUsername);
            phoneNumber = itemView.findViewById(R.id.txtPhone);
            bookingDate = itemView.findViewById(R.id.txtBookDate);
            bookingTime = itemView.findViewById(R.id.txtBookTime);
        }
    }
}
