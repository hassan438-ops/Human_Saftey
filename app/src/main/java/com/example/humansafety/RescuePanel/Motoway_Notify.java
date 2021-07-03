package com.example.humansafety.RescuePanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;
import android.widget.Toast;

import com.example.humansafety.Adapter.Motorway;
import com.example.humansafety.R;
import com.example.humansafety.model.Motorway_model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Motoway_Notify extends AppCompatActivity {

    RecyclerView recyclerView;
    Motorway motorway;
    Motorway mtAdap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motoway__notify);

        recyclerView = findViewById(R.id.RV_MN);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        FirebaseRecyclerOptions<Motorway_model> options
                = new FirebaseRecyclerOptions.Builder<Motorway_model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Call Record").child("Motorway"), Motorway_model.class)
                .build();
        mtAdap = new Motorway(options);
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