package com.lfm.rxdemo.manager;

import com.lfm.rxdemo.api.GithubService;
import com.lfm.rxdemo.model.methods.GetSearchRepo;
import com.lfm.rxdemo.util.Constants;

import retrofit.Retrofit;
import rx.Observable;

/**
 * Created by mogwai on 27/12/2015.
 */
public class SearchManager {

    private static SearchManager instance;

    private final GithubService githubService;

    private SearchManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL_API)
                .build();

        githubService = retrofit.create(GithubService.class);
    }

    public static SearchManager getInstance() {
        if (instance == null) {
            instance = new SearchManager();
        }
        return instance;
    }

    public Observable<GetSearchRepo> getSearch(String search) {
        return githubService.getSearch(search);
    }

}
