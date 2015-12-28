package com.lfm.rxdemo.api;

import com.lfm.rxdemo.model.methods.GetSearchRepo;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface GithubService {

    @GET("/search/repositories")
    Call<GetSearchRepo> getSearch(@Query("q") String search);
}
