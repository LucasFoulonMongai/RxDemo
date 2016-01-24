package com.lfm.rxdemo.manager;

import com.lfm.rxdemo.dao.GithubDao;
import com.lfm.rxdemo.model.methods.GetSearchRepo;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by Lucas FOULON-MONGAÏ, github.com/LucasFoulonMongai on 27/12/2015.
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
        //This is typically the place where you want to combine your observable to add :
        //-Cache management (load & save)
        //-Network strategy (retry on failure, reconnection)
        //-Side effect (notify some subjects)
        //-etc
        return githubDao.getOnlineSearch(search);
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
