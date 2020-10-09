package com.davis.uzaspeedy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    List<FarmersData> farmersDataList;
    public RecyclerAdapter(List<FarmersData> farmersDataList) {
        this.farmersDataList = farmersDataList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        FarmersData farmersData = farmersDataList.get(position);
        holder.name.setText(farmersData.getFarmName());
        holder.location.setText(farmersData.getFarmLocation());
        holder.image.setImageResource(farmersData.getImageId());

    }

    @Override
    public int getItemCount() {
        return farmersDataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name, location;
        public int phoneNumber;
        public ImageView image;
        LinearLayout parent;
        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            name = itemView.findViewById(R.id.product_name);
            location = itemView.findViewById(R.id.product_location);
            image = itemView.findViewById(R.id.product_image);

        }
    }
    //list goes here

    //context goes here

}
