package com.lfm.rxdemo.presenter;

import com.lfm.rxdemo.manager.SearchManager;
import com.lfm.rxdemo.presenter.contract.SearchContract;
import com.lfm.rxdemo.rxutils.ObserverLinker;

/**
 * Created by mogwai on 27/12/2015.
 */
public class SearchPresenter extends ObserverLinker {

    private final SearchContract viewContract;
    private final SearchManager searchManager;

    public SearchPresenter(SearchContract viewContract) {
        this.viewContract = viewContract;
        searchManager = SearchManager.getInstance();
    }

    public void search(String search) {
        searchManager.publishSearchField(search);
    }
}
