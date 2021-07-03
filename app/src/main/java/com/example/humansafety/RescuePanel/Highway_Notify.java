package com.example.humansafety.RescuePanel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.humansafety.Adapter.Highway;
import com.example.humansafety.Adapter.Motorway;
import com.example.humansafety.R;
import com.example.humansafety.model.Motorway_model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Highway_Notify extends AppCompatActivity {

    RecyclerView recyclerView;
    Highway HighAdap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highway__notify);
        recyclerView=findViewById(R.id.RV_HW);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        FirebaseRecyclerOptions<Motorway_model> options
                = new FirebaseRecyclerOptions.Builder<Motorway_model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Call Record").child("Highway"), Motorway_model.class)
                .build();
       HighAdap = new Highway(options);
        recyclerView.setAdapter(HighAdap);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        HighAdap.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override
    protected void onStop()
    {
        super.onStop();
       HighAdap.stopListening();
    }
}