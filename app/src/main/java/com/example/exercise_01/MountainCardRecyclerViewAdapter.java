package com.example.exercise_01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercise_01.network.ImageRequest;
import com.example.exercise_01.network.MountainEntry;

import java.util.List;

public class MountainCardRecyclerViewAdapter extends RecyclerView.Adapter<MountainCardViewHolder> {

    private List<MountainEntry> mountainList;
    private ImageRequest imageRequest;

    MountainCardRecyclerViewAdapter(List<MountainEntry> mountainList){

        this.mountainList = mountainList;
        imageRequest = ImageRequest.getInstance();
    }

    @NonNull
    @Override
    public MountainCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mountain_card, parent, false);

        return new MountainCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull MountainCardViewHolder holder, int position) {

        if(mountainList != null && position < mountainList.size()){

            MountainEntry mountain = mountainList.get(position);

            holder.mountainName.setText(mountain.name);
            holder.mountainLocation.setText(mountain.location);

            imageRequest.setImageFromUrl(holder.mountainImage, mountain.url);
        }
    }

    @Override
    public int getItemCount() {

        return mountainList.size();
    }
}
