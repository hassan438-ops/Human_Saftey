package com.example.humansafety.RescuePanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.humansafety.R;
import com.example.humansafety.Simple_User.Login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Rescue_login extends AppCompatActivity {

    FirebaseAuth auth;
    ProgressDialog progressDialog;
    Button Reg_Login, Reg_REG;
    EditText emails, passs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescue_login);
        Reg_Login = findViewById(R.id.RLAA_btn_login);
        Reg_REG = findViewById(R.id.Userbutton);
        emails = findViewById(R.id.ARL_TIET_email);
        passs= findViewById(R.id.ARL_TIET_password);


        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(getApplicationContext());

        Reg_REG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegClick(v);
            }
        });
        Reg_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginClick(v);
            }
        });


    }

    void LoginClick(View v) {



        String Adm_email =emails.getText().toString();
        String Adm_pass =passs.getText().toString();


        if(Adm_email.isEmpty() || Adm_pass.isEmpty())
            {

                Toast.makeText(this, "Empty Data", Toast.LENGTH_SHORT).show();

            }
            else
            {
                if ((Adm_email.equals("humansafety@gmail.com")) && (Adm_pass.equals("admin123"))) {
                    auth.signInWithEmailAndPassword(Adm_email, Adm_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(getApplicationContext(), Rescue_Default.class));
                                finish();

                            } else {
                                Toast.makeText(Rescue_login.this, "Incorrect Credential", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
                else {
                    Toast.makeText(this,"Incorrect ......" , Toast.LENGTH_SHORT).show();
                }
            }

}

    void RegClick(View v)
    {
        startActivity(new Intent(getApplicationContext(), Login.class));
    }
}