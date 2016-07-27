package com.lfm.rxdemo.manager;

import com.lfm.rxdemo.dao.GithubDao;
import com.lfm.rxdemo.model.methods.GetSearchRepos;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by Lucas FOULON-MONGAÏ, github.com/LucasFoulonMongai on 27/12/2015.
 */
public class SearchManager {

    private static SearchManager instance;

    private final GithubDao githubDao;
    private final PublishSubject<String> searchFieldSubject;

    private SearchManager() {
        githubDao = GithubDao.getInstance();
        searchFieldSubject = PublishSubject.create();
    }

    public static SearchManager getInstance() {
        if (instance == null) {
            instance = new SearchManager();
        }
        return instance;
    }

    public Observable<GetSearchRepos> getSearch(String search) {
        //This is typically the place where you want to combine your observable to add :
        //-Cache management (load & save)
        //-Network strategy (retry on failure, reconnection)
        //-Side effect (notify some subjects)
        //-etc
        return githubDao.getOnlineSearch(search);
    }

    public Observable<String> getSearchFieldSubject() {
        return searchFieldSubject;
    }

    public void publishSearchField(String search) {
        searchFieldSubject.onNext(search);
    }
}
