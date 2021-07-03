package com.example.humansafety.Simple_User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.humansafety.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Registration extends AppCompatActivity {
    private FirebaseAuth mAuth;
    RadioButton male,Female;

    DatabaseReference alert;
    DatabaseReference missingchild;
    DatabaseReference feedback;
    DatabaseReference Motorway;
    DatabaseReference rescue;
    DatabaseReference harrassment;
    DatabaseReference databaseReference;
    ProgressDialog progressDialog;

    EditText text_name,text_Address,text_Contact,text_DOB,text_email,text_pass;
    Button btn_login,btn_Reg;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        databaseReference = FirebaseDatabase.getInstance().getReference().child("Registered Account");

        mAuth = FirebaseAuth.getInstance();
        male=findViewById(R.id.AR_rb_male);
        Female=findViewById(R.id.AR_rb_female);
        alert=FirebaseDatabase.getInstance().getReference().child("Alert");
        feedback=FirebaseDatabase.getInstance().getReference().child("Feedback");
        missingchild=FirebaseDatabase.getInstance().getReference().child("Missing Child");
        harrassment=FirebaseDatabase.getInstance().getReference().child("Harrassment");
        rescue=FirebaseDatabase.getInstance().getReference().child("Rescue");
        Motorway=FirebaseDatabase.getInstance().getReference().child("Call Record");

        text_email=findViewById(R.id.AR_TIET_email);
        text_name=findViewById(R.id.AR_TIET_name);
        text_Address=findViewById(R.id.AR_TIET_address);
        text_Contact=findViewById(R.id.AR_TIET_contact);
        text_DOB=findViewById(R.id.AR_TIET_dob);
        text_pass=findViewById(R.id.AR_TIET_pass);
        btn_login=findViewById(R.id.AR_btn_Login);
        btn_Reg=findViewById(R.id.AR_btn_Register);
        progressDialog=new ProgressDialog(this);

        btn_Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_Email = text_email.getText().toString();
                String get_pass = text_pass.getText().toString();
                progressDialog.setTitle("Creating Account");
                progressDialog.setMessage("Wait.......,");
                progressDialog.show();
                progressDialog.setCanceledOnTouchOutside(false);

                mAuth.createUserWithEmailAndPassword(get_Email, get_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Account Created Successfully", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
//
                            HashMap<String, Object> Alert_map = new HashMap<>();
                            Alert_map.put("Contact", " ");
                            Alert_map.put("Message", " ");
                            Alert_map.put("Location", " ");
//
//                            HashMap<String, Object> Alert_Feedback = new HashMap<>();
//                            Alert_Feedback.put("Detail", " ");
//                            Alert_Feedback.put("Name", " ");
//
//                            HashMap<String, Object> Motorway_Notify = new HashMap<>();
//                            Motorway_Notify.put("User", " ");
//                            Motorway_Notify.put("Number", " ");
//
//
//                            //yeh sab likhne k baad firebase authentication se user delete krna kyun k yeh register ho ga tab create ho ga
//                            //pehlse sab k default table mein empty show krwana ha fir hi har user ka get ho ga alaida warna error de de ga
//
                            alert.child(mAuth.getCurrentUser().getUid()).setValue(Alert_map);
//                            feedback.child(mAuth.getCurrentUser().getUid()).setValue(Alert_Feedback);
//                            Motorway.child("Motorway").child(mAuth.getCurrentUser().getUid()).setValue(Motorway_Notify);
                            String get_Contact = text_Contact.getText().toString();
                            String get_Name = text_name.getText().toString();
                            String get_Emails = text_email.getText().toString();
                            String get_Adress = text_Address.getText().toString();
                            String get_dob = text_DOB.getText().toString();
                            String get_passs = text_pass.getText().toString();
                            HashMap<String, Object> map = new HashMap<>();
                            map.put("Name", get_Name);
                            map.put("Email", get_Emails);
                            map.put("Address", get_Adress);
                            map.put("Contact No", get_Contact);
                            map.put("DOB", get_dob);
                            if(male.isChecked())
                            {
                                map.put("Gender","Male");
                            }
                            else
                            {
                                map.put("Gender","Female");
                            }

                            if (get_Contact.isEmpty() || get_Adress.isEmpty() || get_dob.isEmpty() || get_Emails.isEmpty() || get_Name.isEmpty() || get_passs.isEmpty() && (!male.isChecked() || !Female.isChecked())) {
                                Toast.makeText(getApplicationContext(), "Empty DATA", Toast.LENGTH_SHORT).show();
                            } else {
                                databaseReference.child(mAuth.getCurrentUser().getUid()).setValue(map);

                            }


                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                });

            }

        });



        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

}
}