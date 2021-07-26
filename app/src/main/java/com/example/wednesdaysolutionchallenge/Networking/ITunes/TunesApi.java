package com.example.wednesdaysolutionchallenge.Networking.ITunes;

import com.example.wednesdaysolutionchallenge.Models.ItunesModels.RootModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TunesApi {


    @GET("search")
    Call<RootModel> getSongs(@Query("term") ArrayList<String> arrayList);


}
