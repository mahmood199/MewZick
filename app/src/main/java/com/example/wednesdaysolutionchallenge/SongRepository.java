package com.example.wednesdaysolutionchallenge;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.wednesdaysolutionchallenge.Models.Result;

import java.util.ArrayList;
import java.util.List;

public class SongRepository {

    public SongDao songDao;

    public LiveData<List<Result>> arrayListLiveData;

    public SongRepository(Application application) {
        SongDatabase songDatabase = SongDatabase.getInstance(application);
        songDao = songDatabase.songDao();
        arrayListLiveData = songDao.getAllsongs();
    }

    public void insert(Result result) {
        InsertSongAsyncTask insertSongAsyncTask = new InsertSongAsyncTask(songDao);
        insertSongAsyncTask.execute(result);

    }

    public void update(Result result) {
        UpdateSongAsyncTask insertSongAsyncTask = new UpdateSongAsyncTask(songDao);
        insertSongAsyncTask.execute(result);
    }

    public void delete(Result result) {
        DeleteSongAsyncTask insertSongAsyncTask = new DeleteSongAsyncTask(songDao);
        insertSongAsyncTask.execute(result);
    }

    public void deleteAll() {
        DeleteAllSongAsyncTask insertSongAsyncTask = new DeleteAllSongAsyncTask(songDao);
        insertSongAsyncTask.execute();
    }


    public LiveData<List<Result>> getAllSongs() {
        return arrayListLiveData;
    }


    private static class InsertSongAsyncTask extends AsyncTask<Result, Void, Void> {

        private SongDao songDao;

        public InsertSongAsyncTask(SongDao songDao) {
            this.songDao = songDao;
        }

        @Override
        protected Void doInBackground(Result... results) {
            songDao.insert(results[0]);
            return null;
        }
    }


    private static class UpdateSongAsyncTask extends AsyncTask<Result, Void, Void> {

        private SongDao songDao;

        public UpdateSongAsyncTask(SongDao songDao) {
            this.songDao = songDao;
        }

        @Override
        protected Void doInBackground(Result... results) {
            songDao.update(results[0]);
            return null;
        }
    }


    private static class DeleteSongAsyncTask extends AsyncTask<Result, Void, Void> {

        private SongDao songDao;

        public DeleteSongAsyncTask(SongDao songDao) {
            this.songDao = songDao;
        }

        @Override
        protected Void doInBackground(Result... results) {
            songDao.delete(results[0]);
            return null;
        }
    }


    private static class DeleteAllSongAsyncTask extends AsyncTask<Void, Void, Void> {

        private SongDao songDao;

        public DeleteAllSongAsyncTask(SongDao songDao) {
            this.songDao = songDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            songDao.deleteAllSongs();
            return null;
        }
    }


}
