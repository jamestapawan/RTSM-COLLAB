package com.jtdev.rtsm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Bldg_main1 extends AppCompatActivity {

    ImageView lab3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bldg_main1);

        Date currentTime = Calendar.getInstance().getTime();
        TimeZone pstTimeZone = TimeZone.getTimeZone("GMT+8:00");
        Calendar calendar = Calendar.getInstance(pstTimeZone);
        calendar.setTime(currentTime);

        Button Floor2_1 = findViewById(R.id.Floor2_1);
        Button Floor2_2 = findViewById(R.id.Floor2_2);
        lab3 = findViewById(R.id.ComLab3Button);
        Floor2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bldg_main1.this, bldg_main2.class);
                startActivity(intent);
            }
        });

        Floor2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bldg_main1.this, bldg_main2.class);
                startActivity(intent);
            }
        });
    lab3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder comlab3Message = new AlertDialog.Builder(Bldg_main1.this);
            comlab3Message.setTitle("Computer Laboratory 3");
            comlab3Message.setMessage("Schedule: " + calendar.getTime());
            comlab3Message.show();

        }
    });


    }
}