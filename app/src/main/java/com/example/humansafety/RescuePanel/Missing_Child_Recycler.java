package com.example.humansafety.RescuePanel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.humansafety.Adapter.Missing_Child_Adapter;
import com.example.humansafety.Adapter.Rescue_Adapter;
import com.example.humansafety.R;
import com.example.humansafety.model.Missing_Child_Model;
import com.example.humansafety.model.Motorway_model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Missing_Child_Recycler extends AppCompatActivity {
    RecyclerView recyclerView;
    Missing_Child_Adapter mtAdap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing__child__recycler);
        recyclerView = findViewById(R.id.RV_MCN);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        FirebaseRecyclerOptions<Missing_Child_Model> options
                = new FirebaseRecyclerOptions.Builder<Missing_Child_Model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Missing Child"), Missing_Child_Model.class)
                .build();
        mtAdap = new Missing_Child_Adapter(options,getApplicationContext());
        recyclerView.setAdapter(mtAdap);
    }

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