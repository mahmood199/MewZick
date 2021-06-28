package com.example.wednesdaysolutionchallenge.Networking;

import com.example.wednesdaysolutionchallenge.Models.RootModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TunesApi {


    @GET("search")
    Call<RootModel> getSongs();


}
