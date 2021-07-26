package com.example.wednesdaysolutionchallenge.Models.DeezerModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    public List<Data> data ;

    @SerializedName("total")
    @Expose
    public int total ;


    @SerializedName("next")
    @Expose
    public String next ;

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    @SerializedName("prev")
    @Expose
    public String prev;

    public Result() {
    }



    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
