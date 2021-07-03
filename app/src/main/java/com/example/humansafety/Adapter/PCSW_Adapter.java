package com.example.humansafety.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.humansafety.R;
import com.example.humansafety.model.Motorway_model;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class PCSW_Adapter  extends FirebaseRecyclerAdapter<Motorway_model,PCSW_Adapter.ViewHolder> {

    /**
     * Initialize a {@link androidx.recyclerview.widget.RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link com.firebase.ui.database.FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PCSW_Adapter(@NonNull FirebaseRecyclerOptions<Motorway_model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PCSW_Adapter.ViewHolder holder, int position, @NonNull Motorway_model model) {
        holder.Name.setText(model.getName());
        holder.Num.setText(model.getNumber());
        holder.Address.setText(model.getLocation());


    }

    @NonNull
    @Override
    public PCSW_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.motorway_item,parent,false);
        return new PCSW_Adapter.ViewHolder(view);
    }  public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView Name;
        TextView Num;
        TextView Address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.Notify_name);
            Num=itemView.findViewById(R.id.Notify_Number);
            Address=itemView.findViewById(R.id.Notify_Address);

        }
    }
}

