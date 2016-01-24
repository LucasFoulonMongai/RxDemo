package com.lfm.rxdemo.api;

import com.lfm.rxdemo.model.methods.GetSearchRepo;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface GithubService {

    @GET("/search/repositories")
    Observable<GetSearchRepo> getSearch(@Query("q") String search);
}
