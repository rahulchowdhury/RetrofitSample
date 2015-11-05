package com.ledoapp.retrofitsample;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Rahul on 11/5/2015.
 */
public interface GithubClient {
    @GET("/users/{user}")
    public void fetchFromGitHub(@Path("user") String user, Callback<GitHub> github);
}
