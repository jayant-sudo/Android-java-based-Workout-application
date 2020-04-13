package com.example.workoutapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workoutapp.DayListActivity;
import com.example.workoutapp.Modal.DaywiseWorkout;
import com.example.workoutapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DaywiseWorkoutAdapter extends RecyclerView.Adapter<DaywiseWorkoutAdapter.ViewHolder> {

    private Context context;
    private List<DaywiseWorkout> daywiseWorkoutList;
    private String day;
    public DaywiseWorkoutAdapter(Context context, List<DaywiseWorkout> daywiseWorkoutList) {
        this.context = context;
        this.daywiseWorkoutList = daywiseWorkoutList;
    }

    @NonNull
    @Override
    public DaywiseWorkoutAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.daywise_each_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaywiseWorkoutAdapter.ViewHolder holder, int position) {
        Date date=new Date();
       DaywiseWorkout daywise=daywiseWorkoutList.get(position);
       holder.day.setText(daywise.getDay());
       holder.exercise.setText(daywise.getExercise());
       holder.click.setText(daywise.getClick());
        SimpleDateFormat simpleDateformat;
        simpleDateformat = new SimpleDateFormat("EEEE");    // the day of the week spelled out completely
        day=simpleDateformat.format(date);
      if(daywise.getDay().equals(day))
      {
          holder.cardView.setEnabled(true);
          holder.cardView.setBackgroundColor(Color.DKGRAY);
      }
      else{
          holder.cardView.setEnabled(false);
      }
       holder.cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(context, DayListActivity.class);
               intent.putExtra("day",day);
               context.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return daywiseWorkoutList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

     public TextView day,exercise,click;
     public CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            day=itemView.findViewById(R.id.day);
            exercise=itemView.findViewById(R.id.excercise);
            click=itemView.findViewById(R.id.click);
            cardView=itemView.findViewById(R.id.cardview);

        }
    }
}
