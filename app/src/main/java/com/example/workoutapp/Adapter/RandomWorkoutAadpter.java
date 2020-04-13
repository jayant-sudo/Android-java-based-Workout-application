package com.example.workoutapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.workoutapp.Modal.RandomWorkout;
import com.example.workoutapp.R;

import java.util.List;

public class RandomWorkoutAadpter extends RecyclerView.Adapter<RandomWorkoutAadpter.RandomViewHolder> {

   private Context context;
   private List<RandomWorkout> randomWorkoutList;

    public RandomWorkoutAadpter(Context context, List<RandomWorkout> randomWorkoutList) {
        this.context = context;
        this.randomWorkoutList = randomWorkoutList;
    }

    @NonNull
    @Override
    public RandomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.random_each_row,parent,false);
        return new RandomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RandomViewHolder holder, int position) {
        RandomWorkout randomWorkout=randomWorkoutList.get(position);
        holder.random_title.setText(randomWorkout.getTitle());
        holder.random_time.setText(randomWorkout.getTime()+" min");
        Glide.with(context)
                .load(randomWorkout.getPlay_image())
                .placeholder(R.drawable.play)
                .centerCrop()
                .into(holder.play);
        Glide.with(context)
                .load(randomWorkout.getImage())
                .placeholder(R.drawable.eleventh)
               // .centerCrop()
                .into(holder.workout_image);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class RandomViewHolder extends RecyclerView.ViewHolder
    {
        public TextView random_title,random_time;
        public ImageView workout_image;
        public ImageButton play;

        public RandomViewHolder(@NonNull View itemView) {
            super(itemView);
            random_time=itemView.findViewById(R.id.workout_time);
            random_title=itemView.findViewById(R.id.random_title);
            play=itemView.findViewById(R.id.play);
            workout_image=itemView.findViewById(R.id.workout_image);
        }
    }
}
