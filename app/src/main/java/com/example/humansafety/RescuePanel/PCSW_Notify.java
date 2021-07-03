package com.example.humansafety.RescuePanel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.humansafety.Adapter.PCSW_Adapter;
import com.example.humansafety.R;
import com.example.humansafety.model.Motorway_model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class PCSW_Notify extends AppCompatActivity {

    RecyclerView recyclerView;
    PCSW_Adapter pcsAdap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_c_s_w__notify);

        recyclerView = findViewById(R.id.RV_pcsw);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        FirebaseRecyclerOptions<Motorway_model> options
                = new FirebaseRecyclerOptions.Builder<Motorway_model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Call Record").child("PCSW"), Motorway_model.class)
                .build();
        pcsAdap = new PCSW_Adapter(options);
        recyclerView.setAdapter(pcsAdap);
    }

    // Function to tell the app to start getting
    // data from database on starting of the activity
    @Override
    protected void onStart()
    {
        super.onStart();
        pcsAdap.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override
    protected void onStop()
    {
        super.onStop();
        pcsAdap.stopListening();
    }
}