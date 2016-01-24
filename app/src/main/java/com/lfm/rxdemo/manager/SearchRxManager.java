package com.lfm.rxdemo.manager;

import com.lfm.rxdemo.api.GithubService;
import com.lfm.rxdemo.dao.GithubDao;
import com.lfm.rxdemo.model.methods.GetSearchRepo;
import com.lfm.rxdemo.util.Constants;

import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;
import rx.Observable;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func0;
import rx.subjects.PublishSubject;

/**
 * Created by Lucas Foulon on 27/12/2015.
 */
public class SearchRxManager {

    private static SearchRxManager instance;

    private final GithubDao githubDao;
    private final PublishSubject<String> searchFieldSubject;

    private SearchRxManager() {
        githubDao = GithubDao.getInstance();
        searchFieldSubject = PublishSubject.create();
    }

    public static SearchRxManager getInstance() {
        if (instance == null) {
            instance = new SearchRxManager();
        }
        return instance;
    }

    public Observable<GetSearchRepo> getSearch(String search) {
        return Observable.defer(() -> Observable.just(githubDao.doOnlineGetSearch(search)));
    }

    public Observable<String> getSearchField() {
        return searchFieldSubject;
    }

    public void publishSearchField(String search) {
        searchFieldSubject.onNext(search);
    }
}
