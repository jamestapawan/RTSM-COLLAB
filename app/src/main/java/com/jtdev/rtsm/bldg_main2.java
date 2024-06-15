package com.jtdev.rtsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bldg_main2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bldg_main2);
        Button floor1 = findViewById(R.id.Floor1);
        floor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bldg_main2.this, Bldg_main1.class);
                startActivity(intent);
            }
        });
    }
}