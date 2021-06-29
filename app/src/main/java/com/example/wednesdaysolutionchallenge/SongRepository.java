package com.example.wednesdaysolutionchallenge;

import android.app.Application;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.example.wednesdaysolutionchallenge.Models.Result;

import java.util.ArrayList;

public class SongRepository {

    public SongDao songDao;

    public LiveData<ArrayList<Result>> arrayListLiveData;

    public SongRepository(Application application) {
        SongDatabase songDatabase = SongDatabase.getInstance(application);
        songDao = songDatabase.songDao();
        arrayListLiveData = songDao.getAllsongs();
    }

    public void insert(Result result) {

    }

    public void update(Result result) {

    }

    public void delete(Result result) {

    }

    public void deleteAll() {

    }


    public LiveData<ArrayList<Result>> getAllSongs() {
        return arrayListLiveData;
    }



    /*private static class InsertSongAsyncTask extends AsyncTask<Result,void,void>{

        @Override
        protected Result doInBackground(Result... results) {
            return null;
        }
    }*/

}
