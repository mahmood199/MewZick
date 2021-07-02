package com.example.wednesdaysolutionchallenge;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.example.wednesdaysolutionchallenge.Models.Result;
import com.example.wednesdaysolutionchallenge.Models.RootModel;
import com.example.wednesdaysolutionchallenge.Networking.RetrofitClient;
import com.example.wednesdaysolutionchallenge.Networking.TunesApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SongRepository {

    public SongDao songDao;
    public TunesApi tunesApi;
    public LiveData<List<Result>> arrayListLiveData;
    public Application application;

    public SongRepository(Application application) {
        this.application = application;
        SongDatabase songDatabase = SongDatabase.getInstance(application);
        songDao = songDatabase.songDao();
        arrayListLiveData = songDao.getAllsongs();
        tunesApi = RetrofitClient.getRetrofitInstance().create(TunesApi.class);
    }

    public void insert(Result result) {
        InsertSongAsyncTask insertSongAsyncTask = new InsertSongAsyncTask(songDao);
        insertSongAsyncTask.execute(result);

    }


    public void insertAll(ArrayList<Result> resultArrayList) {

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
        DeleteAllSongAsyncTask deleteAllSongAsyncTask = new DeleteAllSongAsyncTask(songDao);
        deleteAllSongAsyncTask.execute();
    }

    public void putSearchedResultToDatabase() {
        ArrayList<Result> resultArrayList = new ArrayList<>();

        //getArraylist from Api


        //

        InsertAllSongAsyncTask insertAllSongAsyncTask = new InsertAllSongAsyncTask(songDao);
        insertAllSongAsyncTask.execute(resultArrayList);
    }

    public LiveData<List<Result>> getAllSongs() {
        return arrayListLiveData;
    }


    public ArrayList<Result> getAllSongs(ArrayList<String> stringArrayList) {

        ArrayList<Result> arrayList = new ArrayList<>();
        RootModel rootModel;





        Call<RootModel> rootModelCall = tunesApi.getSongs(stringArrayList);
        rootModelCall.enqueue(new Callback<RootModel>() {
            @Override
            public void onResponse(Call<RootModel> call, Response<RootModel> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(application, "Network operation failed", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(application, "Network operation Succesful", Toast.LENGTH_SHORT).show();


                if (response.body() != null) {
                    response.body().setResults(response.body().results);

                    for (Result result : response.body().results) {
                        Log.i("TAGTAGRepository", result.artistName);
                    }

                    arrayList.addAll(response.body().results);

                }
            }

            @Override
            public void onFailure(Call<RootModel> call, Throwable t) {
                Toast.makeText(application, "Network operation failed", Toast.LENGTH_SHORT).show();




            }
        });

        Log.i("TAGTAGRepository", String.valueOf(arrayList.size()));
        return arrayList;
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


    public static class InsertAllSongAsyncTask extends AsyncTask<ArrayList<Result>, Void, Void> {

        private SongDao songDao;

        public InsertAllSongAsyncTask(SongDao songDao) {
            this.songDao = songDao;
        }


        @Override
        protected Void doInBackground(ArrayList<Result>... arrayLists) {

            ArrayList<Result> resultArrayList = arrayLists[0];

            for (Result result : resultArrayList) {
                songDao.insert(result);
            }

            return null;
        }
    }

}
