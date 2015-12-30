package com.lfm.rxdemo.presenter;

import com.lfm.rxdemo.manager.SearchRxManager;
import com.lfm.rxdemo.presenter.contract.InputContract;
import com.lfm.rxdemo.rxutils.ObserverLinker;

/**
 * Created by Lucas Foulon on 27/12/2015.
 */
public class InputPresenter extends ObserverLinker {

    private final InputContract viewContract;
    private final SearchRxManager searchRxManager;

    public InputPresenter(InputContract viewContract) {
        this.viewContract = viewContract;
        searchRxManager = SearchRxManager.getInstance();
    }

    public void search(String search) {
        searchRxManager.publishSearchField(search);
    }
}
