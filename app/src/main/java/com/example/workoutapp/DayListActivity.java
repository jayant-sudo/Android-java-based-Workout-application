package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.widget.TextView;

import com.example.workoutapp.Adapter.RecylerViewAdapter;
import com.example.workoutapp.Modal.Workout;

import java.util.ArrayList;

import java.util.List;

public class DayListActivity extends AppCompatActivity {
    private RecyclerView recyclerView2;
    private List<Workout> workoutList;
    private RecylerViewAdapter recylerViewAdapter;
    private String day;
    private TextView actual_day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_list);
        workoutList=new ArrayList<>();
        recyclerView2=findViewById(R.id.recyclerview2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(gridLayoutManager);
       actual_day=findViewById(R.id.actual_day);
        recyclerView2.setHasFixedSize(true);
        getActualday();
        prepareWorkout();
        recylerViewAdapter=new RecylerViewAdapter(DayListActivity.this,workoutList);
        recyclerView2.setAdapter(recylerViewAdapter);

    }
    private void prepareWorkout()
    {
        int[] covers = new int[]{R.drawable.first,R.drawable.second,R.drawable.third,R.drawable.fourth,R.drawable.fifth,R.drawable.sixth,
                R.drawable.seventh,R.drawable.eight,R.drawable.ninth,R.drawable.tenth,R.drawable.eleventh,R.drawable.twleth,
                R.drawable.thirteen,R.drawable.forteen};
  if(day.equals("Monday")) {
      workoutList.add(new Workout("Push up", covers[0], 60, R.drawable.tick));
      workoutList.add(new Workout("Sit up", covers[1], 60, R.drawable.tick));
      workoutList.add(new Workout("Crunch", covers[2], 60, R.drawable.tick));
      workoutList.add(new Workout("Back exercise", covers[3], 60, R.drawable.tick));
      workoutList.add(new Workout("Knee exercise", covers[4], 60, R.drawable.tick));
  }
        else if(day.equals("Tuesday"))
    {
        workoutList.add(new Workout("Jumping jacks",covers[5],60,R.drawable.tick));
        workoutList.add(new Workout("Deadlifts",covers[6],60,R.drawable.tick));
        workoutList.add(new Workout("Ball crunch",covers[7],60,R.drawable.tick));
        workoutList.add(new Workout("Yoga",covers[8],60,R.drawable.tick));
        workoutList.add(new Workout("Pull up",covers[9],60,R.drawable.tick));
    }
        else if(day.equals("Wednesday"))
  {
      workoutList.add(new Workout("Pull up",covers[9],60,R.drawable.tick));
      workoutList.add(new Workout("Incline bench press",covers[10],60,R.drawable.tick));
      workoutList.add(new Workout("Dumball flye",covers[11],60,R.drawable.tick));
      workoutList.add(new Workout("Hack squat ",covers[12],60,R.drawable.tick));
      workoutList.add(new Workout("Bench crunches",covers[13],60,R.drawable.tick));
  }
        else if(day.equals("Thursday")){
      workoutList.add(new Workout("Crunch", covers[2], 60, R.drawable.tick));
      workoutList.add(new Workout("Back exercise", covers[3], 60, R.drawable.tick));
      workoutList.add(new Workout("Knee exercise", covers[4], 60, R.drawable.tick));
      workoutList.add(new Workout("Jumping jacks",covers[5],60,R.drawable.tick));
      workoutList.add(new Workout("Deadlifts",covers[6],60,R.drawable.tick));
  }
        else if(day.equals("Friday"))

  {
      workoutList.add(new Workout("Jumping jacks",covers[5],60,R.drawable.tick));
      workoutList.add(new Workout("Deadlifts",covers[6],60,R.drawable.tick));
      workoutList.add(new Workout("Ball crunch",covers[7],60,R.drawable.tick));
      workoutList.add(new Workout("Crunch", covers[2], 60, R.drawable.tick));
      workoutList.add(new Workout("Back exercise", covers[3], 60, R.drawable.tick));
  }
        else if(day.equals("Saturday"))
  {
      workoutList.add(new Workout("Knee exercise", covers[4], 60, R.drawable.tick));
      workoutList.add(new Workout("Jumping jacks",covers[5],60,R.drawable.tick));
      workoutList.add(new Workout("Deadlifts",covers[6],60,R.drawable.tick));
      workoutList.add(new Workout("Ball crunch",covers[7],60,R.drawable.tick));
      workoutList.add(new Workout("Crunch", covers[2], 60, R.drawable.tick));
  }
        else if(day.equals("Sunday"))
  {
      workoutList.add(new Workout("Ball crunch",covers[7],60,R.drawable.tick));
      workoutList.add(new Workout("Yoga",covers[8],60,R.drawable.tick));
      workoutList.add(new Workout("Pull up",covers[9],60,R.drawable.tick));
      workoutList.add(new Workout("Knee exercise", covers[4], 60, R.drawable.tick));
      workoutList.add(new Workout("Jumping jacks",covers[5],60,R.drawable.tick));
  }

    }

    private void getActualday()
    {
        Bundle bundle=getIntent().getExtras();
        if(bundle !=null)
        {
            day=bundle.getString("day");
            actual_day.setText(day+" Workouts");
        }
    }
}





