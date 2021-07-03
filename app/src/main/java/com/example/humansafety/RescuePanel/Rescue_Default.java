package com.example.humansafety.RescuePanel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.humansafety.R;

public class Rescue_Default extends AppCompatActivity {

    CardView btn_Motorway,btn_15,btn_pcsw,btn_1122,Missing_Childs,Harrassment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescue__default);
        btn_Motorway=findViewById(R.id.RD_MT);
        btn_15=findViewById(R.id.RD_15);
        btn_pcsw=findViewById(R.id.RD_PCSW);
        Harrassment=findViewById(R.id.RD_Harrassment);
        btn_1122=findViewById(R.id.RD_Resc);
        Missing_Childs=findViewById(R.id.RD_MC);

        Harrassment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Harrassment_Notify.class));
            }
        });
        btn_Motorway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Motoway_Notify.class));

            }
        });
        Missing_Childs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Missing_Child_Recycler.class));

            }
        });
        btn_pcsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PCSW_Notify.class));

            }
        });
        btn_1122.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Rescue_Notify.class));

            }
        });
        btn_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Alert_15_Notify.class));

            }
        });

    }
}