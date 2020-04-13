package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
  private Button random ,daywisemode;
    String day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        random=findViewById(R.id.random);
        daywisemode=findViewById(R.id.daywisemode);
        random.setOnClickListener(this);
        daywisemode.setOnClickListener(this);
        Date now = new Date();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("E");
        simpleDateformat = new SimpleDateFormat("EEEE");    // the day of the week spelled out completely
        day=simpleDateformat.format(now);
       // Log.d("main", "onCreate: "+simpleDateformat.format(now));
    }

    @Override
    public void onClick(View view) {
       switch (view.getId())
       {
           case R.id.random:
                 startActivity(new Intent(HomeActivity.this,MainActivity.class));
                   break;
           case R.id.daywisemode:
                   Intent intent=new Intent(HomeActivity.this,DaywiseActivity.class);
                   intent.putExtra("day",day);
                   startActivity(intent);
                   break;
           default:
                  break;
       }
    }
}
