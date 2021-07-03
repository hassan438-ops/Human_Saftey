package com.example.humansafety.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.humansafety.R;
import com.example.humansafety.model.Harrassment_Model;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Harrassment_Adapter  extends FirebaseRecyclerAdapter<Harrassment_Model,Harrassment_Adapter.ViewHolder> {
    Context context;
    public Harrassment_Adapter(@NonNull FirebaseRecyclerOptions<Harrassment_Model> options, Context context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull Harrassment_Adapter.ViewHolder holder, int position, @NonNull Harrassment_Model model) {
        holder.name.setText(model.getName());
        holder.father.setText(model.getFather_Name());
        holder.gender.setText(model.getGender());
        holder.cnic.setText(model.getCNIC());
        holder.num.setText(model.getContact());
        holder.secnum.setText(model.getSecondary_Contact());
        holder.district.setText(model.getDistrict());
        holder.dob.setText(model.getDOB());
        holder.address.setText(model.getAddress());
        holder.tehsil.setText(model.getTehsil());
        holder.type.setText(model.getType());
        holder.complaint.setText(model.getComplaint());


    }

    @NonNull
    @Override
    public Harrassment_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.harrassment_complaint,parent,false);
        return new Harrassment_Adapter.ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        EditText name,father,num,cnic,secnum,address,district,tehsil,type,dob,complaint,gender;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.AHC_TIET_name);
            father=itemView.findViewById(R.id.AHC_TIET_FN_HN);
            cnic=itemView.findViewById(R.id.AHC_TIET_cnic);
            num=itemView.findViewById(R.id.AHC_TIET_contact);
            secnum=itemView.findViewById(R.id.AHC_TIET_sec_contact);
            district=itemView.findViewById(R.id.AHC_TIET_district);
            tehsil=itemView.findViewById(R.id.AHC_TIET_tehsil);
           type=itemView.findViewById(R.id.AHC_TIET_type);
            dob=itemView.findViewById(R.id.AHC_TIET_date_of_birth);
            address=itemView.findViewById(R.id.AHC_TIET_address);
            complaint=itemView.findViewById(R.id.AHC_TIET_complaint);
            gender=itemView.findViewById(R.id.AHC_TIET_Gender);

        }
    }
}

