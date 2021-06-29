package com.example.wednesdaysolutionchallenge;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.wednesdaysolutionchallenge.Models.Result;

import java.util.ArrayList;

@Dao
public interface SongDao {


    @Insert
    void insert(Result result);

    @Update
    void update(Result result);

    @Delete
    void delete(Result result);

    @Query("SELECT * FROM songs_table ORDER BY trackName ASC")
    LiveData<ArrayList<Result>> getAllsongs();


    @Query("DELETE FROM songs_table")
    void deleteAllSongs();
}
