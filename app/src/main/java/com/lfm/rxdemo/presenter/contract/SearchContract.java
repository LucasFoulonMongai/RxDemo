package com.lfm.rxdemo.presenter.contract;

import com.lfm.rxdemo.model.Repository;

import java.util.List;

/**
 * Created by mogwai on 27/12/2015.
 */
public interface SearchContract {

    void showResults(List<Repository> repositoryList);
}
