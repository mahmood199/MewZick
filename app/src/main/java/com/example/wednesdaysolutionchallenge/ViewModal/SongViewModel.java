package com.example.wednesdaysolutionchallenge.ViewModal;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.wednesdaysolutionchallenge.Models.Result;
import com.example.wednesdaysolutionchallenge.SongRepository;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SongViewModel extends AndroidViewModel {

    SongRepository songRepository;
    LiveData<List<Result>> listLiveData;
    Application application;

    public SongViewModel(@NonNull @NotNull Application application) {
        super(application);

        this.application = application;
        songRepository = new SongRepository(application);
        listLiveData = songRepository.getAllSongs();
    }


    public void insert(Result result) {
        songRepository.insert(result);
    }


    public void insertAll(ArrayList<Result> resultArrayList) {
        songRepository.insertAll(resultArrayList);
    }

    public LiveData<List<Result>> getAllResult() {
        return listLiveData;
    }

    public ArrayList<Result> getAllFromWebService(ArrayList<String> arrayList) {

        ArrayList<Result> resultArrayList = new ArrayList<>();
        Result result = new Result();
        result.setTrackName("NO_INTERNET");


        if (isNetworkAvailable()) {
            resultArrayList = songRepository.getAllSongs(arrayList);
            Log.i("TAGTAGViewModel", String.valueOf(resultArrayList.size()));
        } else
            resultArrayList.add(result);


        return resultArrayList;
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}
