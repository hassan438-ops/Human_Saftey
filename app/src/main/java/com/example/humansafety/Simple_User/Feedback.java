package com.example.humansafety.Simple_User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.humansafety.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Feedback extends AppCompatActivity {
    EditText edt_name,edt_comment;
    DatabaseReference databaseReference;
    FirebaseAuth auth;


    Button btn_Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        edt_name=findViewById(R.id.AF_TIET_name);
        edt_comment=findViewById(R.id.AF_TIET_feedback);
        btn_Submit= findViewById(R.id.AF_btn_Submit);
        auth=FirebaseAuth.getInstance();
        String uid=auth.getCurrentUser().getUid();
        databaseReference=FirebaseDatabase.getInstance().getReference().child("Feedback");




        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_name=edt_name.getText().toString();
                String get_comment=edt_comment.getText().toString();

                HashMap<String, Object> map = new HashMap<>();
                map.put("Detail",get_comment);
                map.put("Name",get_name);


                if(get_name.isEmpty() || get_comment.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Empty DATA", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    databaseReference.child(auth.getCurrentUser().getUid()).setValue(map);

                }
            }
        });
    }
}