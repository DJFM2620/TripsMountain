package com.example.exercise_01;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class MountainCardViewHolder extends RecyclerView.ViewHolder {

    public NetworkImageView mountainImage;
    public TextView mountainName;
    public TextView mountainLocation;

    public MountainCardViewHolder(@NonNull View itemView){

        super(itemView);

        mountainImage = itemView.findViewById(R.id.mountain_image);
        mountainName = itemView.findViewById(R.id.mountain_name);
        mountainLocation = itemView.findViewById(R.id.mountain_location);
    }
}
