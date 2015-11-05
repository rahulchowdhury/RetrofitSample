package com.ledoapp.retrofitsample;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Rahul on 11/5/2015.
 */
public interface WeatherClient {
    @GET("/data/2.5/weather")
    public void fetchFromGitHub(@Query("q") String city, @Query("appid") String appID, Callback<ResponseJSON> responseJSON);
}

