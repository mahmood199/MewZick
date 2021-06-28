package com.example.wednesdaysolutionchallenge.Networking;

import com.example.wednesdaysolutionchallenge.Models.RootModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface TunesApi {


    @GET("search")
    Call<RootModel> getSongs(@Query("term") ArrayList<String> arrayList);


}
