package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.workoutapp.Adapter.RecylerViewAdapter;
import com.example.workoutapp.Modal.Workout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Workout> workoutList;
    private RecylerViewAdapter recylerViewAdapter;
    private Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workoutList=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        start=findViewById(R.id.start);
        recyclerView.setHasFixedSize(true);
        prepareWorkout();
        recylerViewAdapter=new RecylerViewAdapter(MainActivity.this,workoutList);
       recyclerView.setAdapter(recylerViewAdapter);
        click();

    }
    private void prepareWorkout()
    {
        int[] covers = new int[]{R.drawable.first,R.drawable.second,R.drawable.third,R.drawable.fourth,R.drawable.fifth,R.drawable.sixth,
                R.drawable.seventh,R.drawable.eight,R.drawable.ninth,R.drawable.tenth,R.drawable.eleventh,R.drawable.twleth,
                R.drawable.thirteen,R.drawable.forteen};

        workoutList.add(new Workout("Push up",covers[0],60,R.drawable.tick));
        workoutList.add(new Workout("Sit up",covers[1],60,R.drawable.tick));
        workoutList.add(new Workout("Crunch",covers[2],60,R.drawable.tick));
        workoutList.add(new Workout("Back exercise",covers[3],60,R.drawable.tick));
        workoutList.add(new Workout("Knee exercise",covers[4],60,R.drawable.tick));
        workoutList.add(new Workout("Jumping jacks",covers[5],60,R.drawable.tick));
        workoutList.add(new Workout("Deadlifts",covers[6],60,R.drawable.tick));
        workoutList.add(new Workout("Ball crunch",covers[7],60,R.drawable.tick));
        workoutList.add(new Workout("Yoga",covers[8],60,R.drawable.tick));
        workoutList.add(new Workout("Pull up",covers[9],60,R.drawable.tick));
        workoutList.add(new Workout("Incline bench press",covers[10],60,R.drawable.tick));
        workoutList.add(new Workout("Dumball flye",covers[11],60,R.drawable.tick));
        workoutList.add(new Workout("Hack squat ",covers[12],60,R.drawable.tick));
        workoutList.add(new Workout("Bench crunches",covers[13],60,R.drawable.tick));
        Collections.shuffle(workoutList);
    }
    private void click()
    {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,RandomWorkoutActivity.class);
               startActivity(intent);
            }
        });
    }
}
