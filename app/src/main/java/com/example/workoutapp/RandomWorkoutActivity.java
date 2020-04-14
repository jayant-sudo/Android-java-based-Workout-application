package com.example.workoutapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
private int count=3;
private TextView counter;
private MediaPlayer mediaPlayer;
private   MediaPlayer mediaPlayer1;
private  int time=0;
private int i=0;
private TextView title,count_time;
private ImageView tick,wokout_img;
private LinearLayout linearLayout;
private  View itemview;
private TextView breaktime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_workout);
        random_recyclerview=findViewById(R.id.random_recyclerview);
        randomWorkoutList=new ArrayList<>();
        linearLayout=findViewById(R.id.linearlayout);
        getRandomData();
        random_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        random_recyclerview.setHasFixedSize(true);
        randomWorkoutAadpter=new RandomWorkoutAadpter(this,randomWorkoutList);
        random_recyclerview.setAdapter(randomWorkoutAadpter);

        showWarningDialogBox();
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
                counter();

            }
        });

    }
    private void counter() {


        builder=new AlertDialog.Builder(this);

        View itemview=LayoutInflater.from(this).inflate(R.layout.counter,null);
        counter=itemview.findViewById(R.id.counter);

        new CountDownTimer(3000,900){
            @Override
            public void onTick(long l) {
                mediaPlayer1 =MediaPlayer.create(getApplicationContext(),R.raw.countdown);
                mediaPlayer1.start();
                counter.setText(String.valueOf(count));
                count--;
                Log.d("main", "onTick: "+counter);
            }

            @Override
            public void onFinish() {
                counter.setText("Let's Start!!!");
                mediaPlayer1.stop();
                  dialog.dismiss();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       getPosition();
                    }
                },1000);

            }

        }.start();
        builder.setView(itemview);
        dialog=builder.create();
        dialog.show();
    }


    private void getRandomData() {
        int[] covers = new int[]{R.drawable.first,R.drawable.second,R.drawable.third,R.drawable.fourth,R.drawable.fifth,R.drawable.sixth,
                R.drawable.seventh,R.drawable.eight,R.drawable.ninth,R.drawable.tenth,R.drawable.eleventh,R.drawable.twleth,
                R.drawable.thirteen,R.drawable.forteen};

       randomWorkoutList.add(new RandomWorkout("Push up",covers[0],60,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Sit up",covers[1],60,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Crunch",covers[2],60,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Back exercise",covers[3],60,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Knee exercise",covers[4],60,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Jumping jacks",covers[5],60,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Deadlifts",covers[6],60,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Ball crunch",covers[7],60,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Yoga",covers[8],60,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Pull up",covers[9],60,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Incline bench press",covers[10],60,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Dumball flye",covers[11],60,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Hack squat ",covers[12],60,R.drawable.play));
       randomWorkoutList.add(new RandomWorkout("Bench crunches",covers[13],60,R.drawable.play));
        Collections.shuffle(randomWorkoutList);
    }

     private void playMusicInBackground(int music)
     {
             mediaPlayer=new MediaPlayer();
             mediaPlayer=MediaPlayer.create(this,music);
             Log.d("main", "playMusicInBackground: "+mediaPlayer);
             mediaPlayer.start();
     }

     private void getPosition()
     {
      builder=new AlertDialog.Builder(this);
      itemview=LayoutInflater.from(this).inflate(R.layout.countdown,null);
      title=itemview.findViewById(R.id.count_title);
      count_time=itemview.findViewById(R.id.countdown_time);
      tick=itemview.findViewById(R.id.count_tick);
      wokout_img=itemview.findViewById(R.id.count_workout_image);
        getAllPosition(0);
     }

    private void getAllPosition(int i) {
            title.setText(randomWorkoutList.get(i).getTitle());
            wokout_img.setImageResource(randomWorkoutList.get(i).getImage());
            time = randomWorkoutList.get(i).getTime();
            tick.setImageResource(R.drawable.tick);
            new CountDownTimer(7025, 125) {
                @Override
                public void onTick(long l) {
                    count_time.setText("Countdown: " + time);
                    time--;
                    playMusicInBackground(R.raw.song1);
                }

                @Override
                public void onFinish() {

                    mediaPlayer.pause();
                    dialog.dismiss();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            workoutBreak();
                        }
                    },1000);
                }
            }.start();
            builder.setView(itemview);
            dialog = builder.create();
            dialog.show();

        }



    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer1.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer1.stop();
        mediaPlayer.stop();
    }

    private void workoutBreak()
    {

        builder=new AlertDialog.Builder(this);

        View itemview=LayoutInflater.from(this).inflate(R.layout.breakworkout,null);
        breaktime=itemview.findViewById(R.id.counter_break);
        new CountDownTimer(42000, 1000) {
            int count=40;
            @Override
            public void onTick(long l) {
                breaktime.setText(""+count);
                count--;
            }

            @Override
            public void onFinish() {
                dialog.dismiss();
            }
        }.start();
        builder.setView(itemview);
        dialog=builder.create();
        dialog.show();
    }
}


