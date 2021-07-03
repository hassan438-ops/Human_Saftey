package com.example.humansafety.Simple_User;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.humansafety.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class MissingChild extends AppCompatActivity {

    EditText txt_name, txt_age, txt_Father, txt_address, txt_contact, txt_identification, txt_gender, txt_missing;
    Button btn_submit;
    RadioButton male, Female;
    TextView choose;
    ImageView MCImage;
    private Uri filePath;
    private final int PICK_IMAGE_REQUEST = 22;

    FirebaseStorage storage;
    StorageReference storageReference;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing_child);
        MCImage = findViewById(R.id.MC_Image);
        choose = findViewById(R.id.AMC_Choose);
        male = findViewById(R.id.AMC_rb_male);
        Female = findViewById(R.id.AMC_rb_female);
        txt_name = findViewById(R.id.AMC_TIET_name);
        txt_age = findViewById(R.id.AMC_TIET_age);
        txt_Father = findViewById(R.id.AMC_TIET_F_name);
        txt_address = findViewById(R.id.AMC_TIET_address);
        txt_contact = findViewById(R.id.AMC_TIET_contact);
        txt_identification = findViewById(R.id.AMC_TIET_identification);
        txt_missing = findViewById(R.id.AMC_TIET_missingSince);
        btn_submit = findViewById(R.id.AMC_btn_submitReport);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImage();
            }
        });
               btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();

            }
        });
    }


    // Select Image method
    private void SelectImage() {

        // Defining Implicit Intent to mobile gallery
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Image from here..."),PICK_IMAGE_REQUEST);
    }

    // Override onActivityResult method
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {

        super.onActivityResult(requestCode,resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            filePath = data.getData();
            Picasso.get().load(filePath).into(MCImage);
            try {


                Bitmap bitmap = MediaStore.Images.Media.getBitmap( getContentResolver(), filePath);
                MCImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                // Log the exception
                e.printStackTrace();
            }
        }
    }

    // UploadImage method
    private void uploadImage() {
        if (filePath != null) {

            progressDialog= new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference ref= storageReference.child( "images/"+ UUID.randomUUID().toString());
            ref.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot) {
                                    ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            String url = String.valueOf(uri);
                                            SendLink(url);
                                        }
                                    });

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            })
                    .addOnProgressListener(
                            new OnProgressListener<UploadTask.TaskSnapshot>() {

                                // Progress Listener for loading
                                // percentage on the dialog box
                                @Override
                                public void onProgress(
                                        UploadTask.TaskSnapshot taskSnapshot) {
                                    double progress= (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                                    progressDialog.setMessage( "Uploaded "+ (int) progress + "%");
                                }
                            });
        }
    }

    private void SendLink(String url) {

        String get_name = txt_name.getText().toString();
        String get_age = txt_age.getText().toString();
        String get_father = txt_Father.getText().toString();
        String get_address = txt_address.getText().toString();
        String get_contact = txt_contact.getText().toString();
        String get_identification = txt_identification.getText().toString();
        String get_missing = txt_missing.getText().toString();


        HashMap<String, Object> map = new HashMap<>();
        map.put("Name", get_name);
        map.put("Age", get_age);
        map.put("Address", get_address);
        map.put("Father_Name", get_father);
        map.put("Contact", get_contact);
        map.put("Identification_Mark", get_identification);
        map.put("Missing_Since", get_missing);
        map.put("Image_URL", url);
        if (male.isChecked()) {
            map.put("Gender", "Male");
        } else {
            map.put("Gender", "Female");
        }


        if (get_contact.isEmpty() || get_address.isEmpty() || get_age.isEmpty() || get_father.isEmpty() || get_name.isEmpty() || get_identification.isEmpty() || get_missing.isEmpty() && (!male.isChecked() || !Female.isChecked())) {
            Toast.makeText(getApplicationContext(), "Empty DATA", Toast.LENGTH_SHORT).show();
        } else {
            FirebaseDatabase.getInstance().getReference().child("Missing Child").child(get_name).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    progressDialog.dismiss();
                    Toast.makeText(MissingChild.this, "Uploaded", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
