package com.example.humansafety.RescuePanel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import com.example.humansafety.Adapter.Alert_15;
import com.example.humansafety.Adapter.Harrassment_Adapter;
import com.example.humansafety.R;
import com.example.humansafety.model.Harrassment_Model;
import com.example.humansafety.model.Motorway_model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Harrassment_Notify extends AppCompatActivity {
    RecyclerView recyclerView;
    Harrassment_Adapter Adap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harrassment__notify);
        recyclerView=findViewById(R.id.HRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        FirebaseRecyclerOptions<Harrassment_Model> options
                = new FirebaseRecyclerOptions.Builder<Harrassment_Model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Harrassment"), Harrassment_Model.class)
                .build();
        Adap = new Harrassment_Adapter(options,getApplicationContext());
        recyclerView.setAdapter(Adap);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Adap.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override
    protected void onStop()
    {
        super.onStop();
        Adap.stopListening();
    }
}