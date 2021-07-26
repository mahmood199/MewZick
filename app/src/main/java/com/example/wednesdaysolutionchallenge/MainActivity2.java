package com.example.wednesdaysolutionchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.wednesdaysolutionchallenge.Adapter.ITunesSongsAdapter;
import com.example.wednesdaysolutionchallenge.Models.ItunesModels.Result;
import com.example.wednesdaysolutionchallenge.ViewModal.SongViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView showDataRecyclerView;
    SongViewModel songViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        showDataRecyclerView = findViewById(R.id.showDataRecyclerView);

        songViewModel = new ViewModelProvider(this).get(SongViewModel.class);

        songViewModel.getAllResult().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {


                Toast.makeText(MainActivity2.this,"Running",Toast.LENGTH_SHORT).show();

                ArrayList<Result> arrayList = new ArrayList<>(results);

                showDataRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity2.this,2));
                showDataRecyclerView.setAdapter(new ITunesSongsAdapter(MainActivity2.this,arrayList,songViewModel));
            }
        });

    }
}