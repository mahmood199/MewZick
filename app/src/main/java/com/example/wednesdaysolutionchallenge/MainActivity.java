package com.example.wednesdaysolutionchallenge;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string = editText.getText().toString().trim();
                ArrayList<String> arrayList = new ArrayList<>();
                string = string.concat(" ");

                StringBuilder word = new StringBuilder();
                for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i) == ' ') {
                        arrayList.add(word.toString());
                        word = new StringBuilder();
                    }
                    word.append(string.charAt(i));
                }

                Call<RootModel> call = tunesApi.getSongs(arrayList);

                call.enqueue(new Callback<RootModel>() {
                    @Override
                    public void onResponse(Call<RootModel> call1, Response<RootModel> response) {

                        if (!response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();

                        }

                        assert response.body() != null;
                        RootModel rootModel = new RootModel(response.body().getResultCount(), response.body().getResults());

                        ArrayList<Result> resultArrayList = new ArrayList<>(rootModel.getResults());
                        //Log.i("onFailure", String.valueOf(rootModel.resultCount));

                        Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();

                        songs_recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                        songs_recyclerView.setAdapter(new SongsAdapter(MainActivity.this, resultArrayList));

                    }

                    @Override
                    public void onFailure(Call<RootModel> call1, Throwable t) {
                        //Log.i("onFailure", t.getMessage());

                    }
                });

            }
        });


    }
}