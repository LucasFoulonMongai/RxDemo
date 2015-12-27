package com.lfm.rxdemo.api;

import com.lfm.rxdemo.model.GetSearch;

import retrofit.http.Field;
import retrofit.http.GET;
import rx.Observable;

public interface ApiService {

    @GET("/search/repositories?q=?q={search}")
    Observable<GetSearch> getSearch(@Field("search") String search);
}
