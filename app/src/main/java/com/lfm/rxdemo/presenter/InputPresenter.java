package com.lfm.rxdemo.presenter;

import com.lfm.rxdemo.manager.SearchManager;
import com.lfm.rxdemo.rx.Presenter;

/**
 * Created by Lucas FOULON-MONGAÏ, github.com/LucasFoulonMongai on 27/12/2015.
 */
public class InputPresenter extends Presenter {

    private final SearchManager searchManager;

    public InputPresenter() {
        searchManager = SearchManager.getInstance();
    }

    public void search(String search) {
        searchManager.publishSearchField(search);
    }
}
