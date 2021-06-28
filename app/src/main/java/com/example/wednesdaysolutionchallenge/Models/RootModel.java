package com.example.wednesdaysolutionchallenge.Models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RootModel {

    @SerializedName("resultCount")
    @Expose
    public int resultCount ;

    @SerializedName("results")
    @Expose
    public ArrayList<Result> results = new ArrayList<>() ;


    public RootModel(int resultCount, ArrayList<Result> results) {
        this.resultCount = resultCount;
        this.results = results;
    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }
}
