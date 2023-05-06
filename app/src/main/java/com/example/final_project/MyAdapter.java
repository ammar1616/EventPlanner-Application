package com.example.final_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Events> list;

    public MyAdapter(Context context, ArrayList<Events> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.showevents, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Events event = list.get(position);
        holder.ev_name.setText(event.getName());
        holder.ev_description.setText(event.getDescription());
        holder.ev_date.setText(event.fulldate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ev_name, ev_description, ev_date;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ev_name = itemView.findViewById(R.id.ev_name);
            ev_description = itemView.findViewById(R.id.ev_description);
            ev_date = itemView.findViewById(R.id.ev_date);
        }
    }
}
