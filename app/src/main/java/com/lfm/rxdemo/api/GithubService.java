package com.lfm.rxdemo.api;

import com.lfm.rxdemo.model.methods.GetSearchRepos;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface GithubService {

    @GET("/search/repositories")
    Observable<GetSearchRepos> getSearch(@Query("q") String searchField);
}
