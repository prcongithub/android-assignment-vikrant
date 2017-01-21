package com.example.prashant.androidassignment.com.example.network;

import com.example.prashant.androidassignment.com.example.model.DataModel;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by prashant on 21/1/17.
 */
public interface APIService {
    @GET("/posts")
    public void getData(Callback<List<DataModel>> dataList);
}
