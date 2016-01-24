package com.lfm.rxdemo.manager;

import com.lfm.rxdemo.dao.GithubDao;
import com.lfm.rxdemo.manager.task.SearchAsTask;
import com.lfm.rxdemo.model.methods.GetSearchRepo;
import com.lfm.rxdemo.util.AsCallback;

/**
 * Created by Lucas Foulon on 27/12/2015.
 */
public class SearchAsTsManager {

    private static SearchAsTsManager instance;

    private final GithubDao githubDao;

    private SearchAsTsManager() {
        githubDao = GithubDao.getInstance();
    }

    public static SearchAsTsManager getInstance() {
        if (instance == null) {
            instance = new SearchAsTsManager();
        }
        return instance;
    }


    public void getSearch(String search, AsCallback<GetSearchRepo> asCallback) {
        new SearchAsTask(asCallback, githubDao, search).execute();
    }

}
