package com.ledoapp.retrofitsample;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by Rahul on 11/5/2015.
 */
public class ServiceGenerator {

    private static final String BASE_URL = "http://api.openweathermap.org";

    private static RestAdapter.Builder builder = new RestAdapter.Builder().setEndpoint(BASE_URL).setClient(new OkClient(new OkHttpClient()));

    public static <S> S createService(Class<S> serviceClass) {
        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass, final AccessToken accessToken) {
        if(accessToken != null) {
            builder.setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addHeader("Accept","application/json");
                    request.addHeader("Authorization", accessToken.getTokenType() + " " + accessToken.getAccessToken());
                }
            });
        }
        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);
    }
}
