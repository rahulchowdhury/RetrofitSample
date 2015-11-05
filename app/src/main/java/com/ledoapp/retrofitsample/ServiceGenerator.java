package com.ledoapp.retrofitsample;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by Rahul on 11/5/2015.
 */
public class ServiceGenerator {

    private static final String BASE_URL = "https://api.github.com";

    private static RestAdapter.Builder builder = new RestAdapter.Builder().setEndpoint(BASE_URL).setClient(new OkClient(new OkHttpClient()));

    public static <S> S createService(Class<S> serviceClass) {
        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);
    }
}
