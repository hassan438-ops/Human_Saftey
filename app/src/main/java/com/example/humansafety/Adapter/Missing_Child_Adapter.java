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
import com.example.humansafety.model.Missing_Child_Model;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

public class Missing_Child_Adapter  extends FirebaseRecyclerAdapter<Missing_Child_Model,Missing_Child_Adapter.ViewHolder> {
Context context;
    public Missing_Child_Adapter(@NonNull FirebaseRecyclerOptions<Missing_Child_Model> options, Context context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull Missing_Child_Adapter.ViewHolder holder, int position, @NonNull Missing_Child_Model model) {
        holder.name.setText(model.getName());
        holder.age.setText(model.getAge());
        holder.father.setText(model.getFather_Name());
        holder.mark.setText(model.getIdentification_Mark());
        holder.num.setText(model.getContact());
        holder.address.setText(model.getAddress());
        holder.missingSince.setText(model.getMissing_Since());
        holder.gender.setText(model.getGender());
        Glide.with(context).load(model.getImage_URL()).into(holder.profile);

    }

    @NonNull
    @Override
    public Missing_Child_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.missing_child_items,parent,false);
        return new Missing_Child_Adapter.ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       TextView name,age,father,mark,num,address,missingSince,gender;
        ImageView profile;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.AMCV_tv_name);
            age=itemView.findViewById(R.id.AMCV_tv_age);
            address=itemView.findViewById(R.id.AMCV_tv_address);
            father=itemView.findViewById(R.id.AMCV_tv_father_name);
            mark=itemView.findViewById(R.id.AMCV_tv_identification_mark);
            num=itemView.findViewById(R.id.AMCV_tv_contact);
            missingSince=itemView.findViewById(R.id.AMCV_tv_missing_since);
            gender=itemView.findViewById(R.id.AMCV_tv_gender);
            profile=itemView.findViewById(R.id.AMCV_imageView);
        }
    }
}
