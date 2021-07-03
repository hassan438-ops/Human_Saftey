package com.example.humansafety.Simple_User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.humansafety.R;
import com.example.humansafety.RescuePanel.Missing_Child_Recycler;

public class Default extends AppCompatActivity {
    CardView Alert,MissingChild,Harrasment,Feedback,Rescue,All_Missing_Child;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
        Alert =findViewById(R.id.Alert_user_btn);
        MissingChild =findViewById(R.id.Missing_user_btn);
        Feedback =findViewById(R.id.Feedback_user_btn);
        Rescue =findViewById(R.id.Rescue_user_btn);
        Harrasment=findViewById(R.id.Harrasment_user_btn);
        All_Missing_Child=findViewById(R.id.Missing_Children_user_btn);

        All_Missing_Child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Missing_Child_Recycler.class));
            }
        });

        Alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertFunction(v);
            }
        });

        MissingChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MissingChildFunction(v);
            }
        });
        Feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedbackFunction(v);
            }
        });
        Rescue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RescueFunction(v);
            }
        });
        Harrasment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HarrasmentFunction(v);
            }
        });

    }
    public void AlertFunction(View view)
    {
startActivity(new Intent(getApplicationContext(), com.example.humansafety.Simple_User.Alert.class));

    }
    public void MissingChildFunction(View view)
    {
        startActivity(new Intent(getApplicationContext(), com.example.humansafety.Simple_User.MissingChild.class));

    }
    public void FeedbackFunction(View view)
    {
        startActivity(new Intent(getApplicationContext(), com.example.humansafety.Simple_User.Feedback.class));
    }
    public void RescueFunction(View view)
    {
        startActivity(new Intent(getApplicationContext(), com.example.humansafety.Simple_User.Rescue.class));
    }
    public void HarrasmentFunction(View view)
    {
        startActivity(new Intent(getApplicationContext(), Harrassment.class));
    }

}