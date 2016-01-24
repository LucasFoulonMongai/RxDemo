package com.lfm.rxdemo.dao;

import com.lfm.rxdemo.api.GithubService;
import com.lfm.rxdemo.model.methods.GetSearchRepo;
import com.lfm.rxdemo.util.Constants;

import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;
import rx.exceptions.OnErrorThrowable;

/**
 * Created by l.foulon on 30/12/15.
 */
public class GithubDao {

    private static GithubDao instance;
    private final GithubService githubService;

    private GithubDao(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL_API)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        githubService = retrofit.create(GithubService.class);
    }

    public static GithubDao getInstance() {
        if(instance == null){
            instance = new GithubDao();
        }
        return instance;
    }

    public GetSearchRepo doOnlineGetSearch(String search) {
        try {
            return githubService.getSearch(search).execute().body();
        } catch (Exception e) {
            throw OnErrorThrowable.from(e);
        }
    }
}
