package com.example.workoutapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.workoutapp.Modal.Workout;
import com.example.workoutapp.R;

import java.util.List;

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.ViewHolder> {
   private Context context;
   private List<Workout> workoutList;

    public RecylerViewAdapter(Context context, List<Workout> workoutList) {
        this.context = context;
        this.workoutList = workoutList;
    }

    @NonNull
    @Override
    public RecylerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.each_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerViewAdapter.ViewHolder holder, int position) {
      Workout workout=workoutList.get(position);
      holder.title.setText(workout.getTitle());
      holder.time.setText(String.valueOf(workout.getTime())+" secs");

        Glide
                .with(context)
                .load(workout.getImage())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.image);
        Glide
                .with(context)
                .load(workout.getTick())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.tick);
    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title,time;
        public ImageView image,tick;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            time=itemView.findViewById(R.id.time);
            image=itemView.findViewById(R.id.image);
            tick=itemView.findViewById(R.id.tick);
        }
    }
}
