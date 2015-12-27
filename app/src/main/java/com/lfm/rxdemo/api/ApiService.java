package com.lfm.rxdemo.api;

import com.lfm.rxdemo.model.GetSearch;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface ApiService {

    @GET("/api/mobile/flux/recherche/{search}")
    Observable<GetSearch> getSearch(@Path("search") String search);
}
