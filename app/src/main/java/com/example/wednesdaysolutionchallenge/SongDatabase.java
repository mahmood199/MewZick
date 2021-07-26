package com.example.wednesdaysolutionchallenge;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.wednesdaysolutionchallenge.Models.ItunesModels.Result;

import org.jetbrains.annotations.NotNull;


@Database(entities = Result.class, version = 1)
public abstract class SongDatabase extends RoomDatabase {

    public static SongDatabase instance;

    public abstract SongDao songDao();


    public static synchronized SongDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), SongDatabase.class, "song_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new PopulateDBAsyncTask(instance).execute();
        }
    };




    private static class PopulateDBAsyncTask extends AsyncTask<Void,Void,Void>{

        private SongDao songDao;

        public PopulateDBAsyncTask(SongDatabase songDatabase) {
            this.songDao = songDatabase.songDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Result result = new Result();
            result.setArtistName("Mahmood");
            result.setPreviewUrl("MahmoodPreviewUrl");
            result.setTrackTimeMillis(69);
            result.setArtworkUrl100("MahmoodArtWorkUrl");
            result.setTrackViewUrl("MahmoodTrackViewUrl");
            result.setTrackName("MahmoodTrackName");
            result.setWrapperType("MahmoodWrapperType");

            songDao.insert(result);


            return null;
        }
    }

}
