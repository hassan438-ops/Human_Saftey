package com.example.humansafety.RescuePanel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.humansafety.Adapter.Motorway;
import com.example.humansafety.Adapter.Rescue_Adapter;
import com.example.humansafety.R;
import com.example.humansafety.model.Motorway_model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Rescue_Notify extends AppCompatActivity {

    RecyclerView recyclerView;
    Rescue_Adapter mtAdap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescue__notify);
        recyclerView = findViewById(R.id.RV_rescue);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        FirebaseRecyclerOptions<Motorway_model> options
                = new FirebaseRecyclerOptions.Builder<Motorway_model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Call Record").child("Rescue1122"), Motorway_model.class)
                .build();
        mtAdap = new Rescue_Adapter(options);
        recyclerView.setAdapter(mtAdap);
    }

    // Function to tell the app to start getting
    // data from database on starting of the activity
    @Override
    protected void onStart()
    {
        super.onStart();
        mtAdap.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override
    protected void onStop()
    {
        super.onStop();
        mtAdap.stopListening();
    }
}