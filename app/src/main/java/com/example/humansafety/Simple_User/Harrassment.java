package com.example.humansafety.Simple_User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.humansafety.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Harrassment extends AppCompatActivity {

    EditText name,FathOrHusb,cnic,Contact,SecondContact,District,Tehsil,Type,DOB,Address,Complaint_Desc;
    Button Submit;
    RadioButton male,female;
    FirebaseAuth auth;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harrassment);

        name=findViewById(R.id.AH_TIET_name);
        FathOrHusb=findViewById(R.id.AH_TIET_FN_HN);
        cnic=findViewById(R.id.AH_TIET_cnic);
        Contact=findViewById(R.id.AH_TIET_contact);
        SecondContact=findViewById(R.id.AH_TIET_sec_contact);
        District=findViewById(R.id.AH_TIET_district);
        Tehsil=findViewById(R.id.AH_TIET_tehsil);
        Type=findViewById(R.id.AH_TIET_type);
        DOB=findViewById(R.id.AH_TIET_date_of_birth);
        Address=findViewById(R.id.AH_TIET_address);
        Complaint_Desc=findViewById(R.id.AH_TIET_complaint);
        Submit=findViewById(R.id.AH_btn_submitComplaint);
        male=findViewById(R.id.AH_rb_male);
        female=findViewById(R.id.AH_rb_female);

        auth=FirebaseAuth.getInstance();
        String uid=auth.getCurrentUser().getUid();


       databaseReference=FirebaseDatabase.getInstance().getReference().child("Harrassment");

       Submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String getName=name.getText().toString();
               String getFath=FathOrHusb.getText().toString();
               String getCnic=cnic.getText().toString();
               String getContact=Contact.getText().toString();
               String getSecContac=SecondContact.getText().toString();
               String getDistrict=District.getText().toString();
               String getTehsil=Tehsil.getText().toString();
               String getType=Type.getText().toString();
               String getDOB=DOB.getText().toString();
               String getAddress= Address.getText().toString();
               String getComplaint=Complaint_Desc.getText().toString();




               HashMap<String,Object> map=new HashMap<>();
               map.put("Name",getName);
               map.put("Father_Name",getFath);
               map.put("CNIC",getCnic);
               map.put("Contact",getContact);
               map.put("Secondary_Contact",getSecContac);
               map.put("District",getDistrict);
               map.put("Tehsil",getTehsil);
               map.put("Type",getType);
               map.put("DOB",getDOB);
               map.put("Address",getAddress);
               map.put("Complaint",getComplaint);
               if(male.isChecked())
               {
                   map.put("Gender","Male");
               }
               else
               {
                   map.put("Gender","Female");
               }

               if (getName.isEmpty() || getFath.isEmpty() || getCnic.isEmpty() || getContact.isEmpty() || getSecContac.isEmpty() || getDistrict.isEmpty()
                       || getTehsil.isEmpty() || getDOB.isEmpty() || getAddress.isEmpty() || getComplaint.isEmpty()   && (!male.isChecked() || !female.isChecked())) {
                   Toast.makeText(getApplicationContext(), "Empty DATA", Toast.LENGTH_SHORT).show();
               } else {
                   databaseReference.child(auth.getCurrentUser().getUid()).setValue(map);
                   Toast.makeText(Harrassment.this, "Submitted", Toast.LENGTH_SHORT).show();
               }



           }
       });


    }
}