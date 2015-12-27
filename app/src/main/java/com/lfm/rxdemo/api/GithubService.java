package com.lfm.rxdemo.api;

import com.lfm.rxdemo.model.methods.GetSearchRepo;

import retrofit.http.Field;
import retrofit.http.GET;
import rx.Observable;

public interface GithubService {

    @GET("/search/repositories?q=?q={search}")
    Observable<GetSearchRepo> getSearch(@Field("search") String search);
}
