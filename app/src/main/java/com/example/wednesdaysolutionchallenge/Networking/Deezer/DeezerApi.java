package com.example.wednesdaysolutionchallenge.Networking.Deezer;

import com.example.wednesdaysolutionchallenge.Models.ItunesModels.RootModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DeezerApi {

    @GET("search")
    Call<RootModel> getSongs(@Query("term") ArrayList<String> arrayList);
}
