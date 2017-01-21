package com.example.prashant.androidassignment.com.example.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by prashant on 21/1/17.
 */
public class RestClient {

    private String API_URL = "http://jsonplaceholder.typicode.com";
    private APIService apiService;

    public RestClient(){
        Gson gson = new GsonBuilder().create();
        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(API_URL)
                .setConverter(new GsonConverter(gson))
                .build();

        apiService = restAdapter.create(APIService.class);

    }

    public APIService getApiService(){
        return apiService;
    }

}
