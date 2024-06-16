package com.jtdev.rtsm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Bldg_main1 extends AppCompatActivity {

    ImageView travel1, travel2, comlab3;
    TextView comlab3_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bldg_main1);

        travel1 = findViewById(R.id.travel1);
        travel2 = findViewById(R.id.travel2);
        comlab3 = findViewById(R.id.Comlab3_Button);

        comlab3_status = findViewById(R.id.Comlab3_Status);

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR); // 12-hour format
        int minute = calendar.get(Calendar.MINUTE);
        int am_pm = calendar.get(Calendar.AM_PM);

        String amPm;
        if (am_pm == Calendar.AM) {
            amPm = "AM";
        } else {
            amPm = "PM";
        }

        String currentTime = (hour + ":" + minute + " " + amPm);

    comlab3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (compareTime(12, 13)){
                Toast.makeText(Bldg_main1.this, "This room is currently VACANT", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(Bldg_main1.this, "A class is ongoing in this room.", Toast.LENGTH_SHORT).show();
            }
            AlertDialog.Builder comlab3Message = new AlertDialog.Builder(Bldg_main1.this);
            comlab3Message.setTitle("Computer Laboratory 3");
            StringBuilder comlab3_content = new StringBuilder();
            comlab3_content.append("Schedule                           SUBJECT\n");
            comlab3_content.append("7:00AM - 10:00AM          HCI\n");
            comlab3_content.append("10:00AM - 11:00AM        HCI\n");
            comlab3_content.append("12:00AM - 1:00PM          VACANT\n");
            comlab3_content.append("1:00AM - 4:00PM             FMP\n");
            comlab3_content.append("4:00AM - 6:00PM             FMP\n");
            comlab3_content.append("\nCurrent Time: ");
            comlab3_content.append(currentTime);
            comlab3Message.setMessage(comlab3_content);
            comlab3Message.show();

        }
    });

    updateTime();
    }
    public boolean compareTime(int time1, int time2) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY); // 24-hour format

        return hour >= time1 && hour < time2;
    }

    void updateTime(){
        if (compareTime(12, 13)){
            comlab3_status.setText("Available");
            comlab3_status.setTextColor(Color.GREEN);
        }else{
            comlab3_status.setText("Occupied");
            comlab3_status.setTextColor(Color.RED);
        }
    }
}