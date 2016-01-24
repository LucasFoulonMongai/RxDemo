package com.lfm.rxdemo.manager;

import com.lfm.rxdemo.api.GithubService;
import com.lfm.rxdemo.model.methods.GetSearchRepo;
import com.lfm.rxdemo.util.Constants;

import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by Lucas FOULON-MONGAÏ, github.com/LucasFoulonMongai on 27/12/2015.
 */
public class SearchManager {

    private static SearchManager instance;

    private final GithubService githubService;
    private final PublishSubject<String> searchFieldSubject;

    private SearchManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL_API)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
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
        return githubService.getSearch(search);
    }

    public Observable<String> getObservableExample(String search) {
        return Observable.defer(() -> Observable.just("exemple1", "exemple2"));
    }

    public Observable<String> getSearchField() {
        return searchFieldSubject;
    }

    public void publishSearchField(String search) {
        searchFieldSubject.onNext(search);
    }
}
