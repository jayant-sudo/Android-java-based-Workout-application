package com.example.workoutapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.workoutapp.Adapter.RandomWorkoutAadpter;
import com.example.workoutapp.Modal.RandomWorkout;
import com.example.workoutapp.Modal.Workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomWorkoutActivity extends AppCompatActivity {
private RecyclerView random_recyclerview;
private List<RandomWorkout> randomWorkoutList;
private RandomWorkoutAadpter randomWorkoutAadpter;
private AlertDialog.Builder builder;
private AlertDialog dialog;
private Button warning_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_workout);
        random_recyclerview=findViewById(R.id.random_recyclerview);
        randomWorkoutList=new ArrayList<>();
        showWarningDialogBox();
        getRandomData();
        random_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        random_recyclerview.setHasFixedSize(true);
        randomWorkoutAadpter=new RandomWorkoutAadpter(this,randomWorkoutList);
        random_recyclerview.setAdapter(randomWorkoutAadpter);


    }

    private void showWarningDialogBox() {
        builder=new AlertDialog.Builder(this);
        View itemview= LayoutInflater.from(this).inflate(R.layout.random_instruction,null);
        warning_btn=itemview.findViewById(R.id.warning_button);
        builder.setView(itemview);
        dialog=builder.create();
        dialog.show();

        warning_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }

    private void getRandomData() {
        int[] covers = new int[]{R.drawable.first,R.drawable.second,R.drawable.third,R.drawable.fourth,R.drawable.fifth,R.drawable.sixth,
                R.drawable.seventh,R.drawable.eight,R.drawable.ninth,R.drawable.tenth,R.drawable.eleventh,R.drawable.twleth,
                R.drawable.thirteen,R.drawable.forteen};

       randomWorkoutList.add(new RandomWorkout("Push up",covers[0],2,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Sit up",covers[1],2,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Crunch",covers[2],2,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Back exercise",covers[3],2,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Knee exercise",covers[4],2,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Jumping jacks",covers[5],2,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Deadlifts",covers[6],2,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Ball crunch",covers[7],2,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Yoga",covers[8],2,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Pull up",covers[9],2,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Incline bench press",covers[10],2,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Dumball flye",covers[11],2,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Hack squat ",covers[12],2,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Bench crunches",covers[13],2,R.drawable.play));
        Collections.shuffle(randomWorkoutList);
    }

}
