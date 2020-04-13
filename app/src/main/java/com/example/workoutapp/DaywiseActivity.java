package com.example.workoutapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.workoutapp.Adapter.DaywiseWorkoutAdapter;
import com.example.workoutapp.Modal.DaywiseWorkout;

import java.util.ArrayList;
import java.util.List;

public class DaywiseActivity extends AppCompatActivity {
 private RecyclerView recyclerView;
 private List<DaywiseWorkout> daywiseWorkouts;
 private DaywiseWorkoutAdapter daywiseWorkoutAdapter;
 private TextView dialog_day,dialog_next;
 private Button dialog_button;
 private String day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daywise);

        recyclerView=findViewById(R.id.recyclerview1);
        daywiseWorkouts=new ArrayList<>();



        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        addDataToListview();
        checkDay();
        daywiseWorkoutAdapter=new DaywiseWorkoutAdapter(this,daywiseWorkouts);
        recyclerView.setAdapter(daywiseWorkoutAdapter);


    }

    private void checkDay() {
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
           day=bundle.getString("day");
        }
        for(DaywiseWorkout dw : daywiseWorkouts)
        {

            if(day.equals(dw.getDay()))
            {
                View itemview= LayoutInflater.from(this).inflate(R.layout.alert_dialog_day,null);
                dialog_day=itemview.findViewById(R.id.dialog_day);
                dialog_next=itemview.findViewById(R.id.dialog_next);
                dialog_button=itemview.findViewById(R.id.dialog_button);
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                dialog_day.setText("it's "+day);
                dialog_next.setText("Click on "+day+" cardboard to check your workout routines!!");
                builder.setView(itemview);
                final AlertDialog dialog=builder.create();
                dialog.show();
                dialog_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                break;
            }
        }
    }

    private void addDataToListview() {
      daywiseWorkouts.add(new DaywiseWorkout("Monday","Workouts","click"));
      daywiseWorkouts.add(new DaywiseWorkout("Tuesday","Workouts","click"));
      daywiseWorkouts.add(new DaywiseWorkout("Wednesday","Workouts","click"));
      daywiseWorkouts.add(new DaywiseWorkout("Thursday","Workouts","click"));
      daywiseWorkouts.add(new DaywiseWorkout("Friday","Workouts","click"));
      daywiseWorkouts.add(new DaywiseWorkout("Saturday","Workouts","click"));
      daywiseWorkouts.add(new DaywiseWorkout("Sunday","Workouts","click"));
    }


}
