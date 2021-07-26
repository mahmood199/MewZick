package com.example.wednesdaysolutionchallenge.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wednesdaysolutionchallenge.Models.DeezerModels.Data;
import com.example.wednesdaysolutionchallenge.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DeezerSongsAdapter extends RecyclerView.Adapter<DeezerSongsAdapter.ViewHolder> {

    Context context;
    ArrayList<Data> dataArrayList;

    public DeezerSongsAdapter(Context context, ArrayList<Data> dataArrayList) {
        this.context = context;
        this.dataArrayList = dataArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_single_deezer_song, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {




    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView song_cover_dezer;
        TextView song_name_deezer,song_artist_deezer;
        FloatingActionButton floatingActionButton;


        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            floatingActionButton = itemView.findViewById(R.id.floatingActionButton);
            song_cover_dezer = itemView.findViewById(R.id.song_cover_dezer);
            song_artist_deezer = itemView.findViewById(R.id.song_artist_deezer);
            song_name_deezer = itemView.findViewById(R.id.song_name_deezer);


        }
    }
}
