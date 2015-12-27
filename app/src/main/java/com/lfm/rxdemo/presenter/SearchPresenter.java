package com.lfm.rxdemo.presenter;

import android.content.Context;

import com.lfm.rxdemo.presenter.contract.SearchContract;

/**
 * Created by mogwai on 27/12/2015.
 */
public class SearchPresenter {

    private final Context context;
    private final SearchContract viewContract;

    public SearchPresenter(Context context, SearchContract viewContract) {
        this.context = context;
        this.viewContract = viewContract;
    }
}
