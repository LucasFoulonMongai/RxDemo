package com.lfm.rxdemo.dao;

import com.lfm.rxdemo.api.GithubService;
import com.lfm.rxdemo.model.methods.GetSearchRepo;
import com.lfm.rxdemo.util.Constants;

import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;

/**
 * Created by l.foulon on 30/12/15.
 */
public class GithubDao {

    private static GithubDao instance;
    private final GithubService githubService;

    private GithubDao() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL_API)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        githubService = retrofit.create(GithubService.class);
    }

    public static GithubDao getInstance() {
        if (instance == null) {
            instance = new GithubDao();
        }
        return instance;
    }

    public Observable<GetSearchRepo> getOnlineSearch(String search) {
        return githubService.getSearch(search);
    }
}
