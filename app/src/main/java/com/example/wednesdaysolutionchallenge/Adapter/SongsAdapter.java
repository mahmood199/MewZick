package com.example.wednesdaysolutionchallenge.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wednesdaysolutionchallenge.Models.Result;
import com.example.wednesdaysolutionchallenge.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {

    Context context;
    ArrayList<Result> arrayList = new ArrayList<>();

    public SongsAdapter(Context context, ArrayList<Result> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_single_song,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        Result result = arrayList.get(position);

        Glide.with(context)
                .load(result.artworkUrl100)
                .into(holder.imageView);

        holder.song_name.setText(result.trackName);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView song_name;


        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            song_name = itemView.findViewById(R.id.song_name);

        }
    }
}
