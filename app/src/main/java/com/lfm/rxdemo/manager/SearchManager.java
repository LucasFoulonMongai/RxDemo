package com.lfm.rxdemo.manager;

import com.lfm.rxdemo.api.GithubService;
import com.lfm.rxdemo.model.methods.GetSearchRepo;
import com.lfm.rxdemo.util.Constants;

import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;
import rx.Observable;
import rx.exceptions.OnErrorThrowable;
import rx.subjects.PublishSubject;

/**
 * Created by mogwai on 27/12/2015.
 */
public class SearchManager {

    private static SearchManager instance;

    private final GithubService githubService;
    private final PublishSubject<String> searchFieldSubject;

    private SearchManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL_API)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        githubService = retrofit.create(GithubService.class);

        searchFieldSubject = PublishSubject.create();
    }

    public static SearchManager getInstance() {
        if (instance == null) {
            instance = new SearchManager();
        }
        return instance;
    }

    public Observable<GetSearchRepo> getSearch(String search) {
        return Observable.defer(() -> Observable.just(doOnlineGetSearch(search)));
    }

    private GetSearchRepo doOnlineGetSearch(String search) {
        try {
            return githubService.getSearch(search).execute().body();
        } catch (Exception e) {
            throw OnErrorThrowable.from(e);
        }
    }

    public Observable<String> getSearchField() {
        return searchFieldSubject;
    }

    public void publishSearchField(String search) {
        searchFieldSubject.onNext(search);
    }
}
