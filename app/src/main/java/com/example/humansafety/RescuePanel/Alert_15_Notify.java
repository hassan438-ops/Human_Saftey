package com.example.humansafety.RescuePanel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.humansafety.Adapter.Alert_15;
import com.example.humansafety.R;
import com.example.humansafety.model.Motorway_model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Alert_15_Notify extends AppCompatActivity {

    RecyclerView recyclerView;
    Alert_15 Adap15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_15__notify);
        recyclerView=findViewById(R.id.RV_15);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        FirebaseRecyclerOptions<Motorway_model> options
                = new FirebaseRecyclerOptions.Builder<Motorway_model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Call Record").child("15"), Motorway_model.class)
                .build();
        Adap15 = new Alert_15(options);
        recyclerView.setAdapter(Adap15);
    }

    // Function to tell the app to start getting
    // data from database on starting of the activity
    @Override
    protected void onStart()
    {
        super.onStart();
        Adap15.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override
    protected void onStop()
    {
        super.onStop();
        Adap15.stopListening();
    }
}