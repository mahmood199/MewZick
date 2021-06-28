package com.example.wednesdaysolutionchallenge;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wednesdaysolutionchallenge.Adapter.SongsAdapter;
import com.example.wednesdaysolutionchallenge.Models.Result;
import com.example.wednesdaysolutionchallenge.Models.RootModel;
import com.example.wednesdaysolutionchallenge.Networking.RetrofitClient;
import com.example.wednesdaysolutionchallenge.Networking.TunesApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView songs_recyclerView;
    EditText editText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songs_recyclerView = findViewById(R.id.songs_recyclerView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        TunesApi tunesApi = RetrofitClient.getRetrofitInstance().create(TunesApi.class);

        Call<RootModel> call = tunesApi.getSongs();


        button.setOnClickListener(v -> call.enqueue(new Callback<RootModel>() {
            @Override
            public void onResponse(Call<RootModel> call1, Response<RootModel> response) {

                if (!response.isSuccessful()) {

                    assert response.body() != null;
                    RootModel rootModel = new RootModel(response.body().resultCount, response.body().results);

                    ArrayList<Result> resultArrayList = new ArrayList<>(rootModel.results);


                    songs_recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                            LinearLayoutManager.VERTICAL, false));
                    songs_recyclerView.setAdapter(new SongsAdapter(MainActivity.this, resultArrayList));
                }

            }

            @Override
            public void onFailure(Call<RootModel> call1, Throwable t) {

            }
        }));



    }
}