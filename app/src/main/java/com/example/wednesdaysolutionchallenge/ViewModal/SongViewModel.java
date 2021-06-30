package com.example.wednesdaysolutionchallenge.ViewModal;

import android.app.Application;
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

    public SongViewModel(@NonNull @NotNull Application application) {
        super(application);


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

        ArrayList<Result> resultArrayList;
        resultArrayList = songRepository.getAllSongs(arrayList);
        Log.i("TAGTAGViewModel", String.valueOf(resultArrayList.size()));
        return resultArrayList;
    }

}
