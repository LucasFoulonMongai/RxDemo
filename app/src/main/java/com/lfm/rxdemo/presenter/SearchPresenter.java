package com.lfm.rxdemo.presenter;

import com.lfm.rxdemo.presenter.contract.SearchContract;

import java.util.ArrayList;

/**
 * Created by mogwai on 27/12/2015.
 */
public class SearchPresenter {

    private final SearchContract viewContract;

    public SearchPresenter(SearchContract viewContract) {
        this.viewContract = viewContract;
    }

    public void search(String search) {
        viewContract.showResults(new ArrayList<>());
    }
}
