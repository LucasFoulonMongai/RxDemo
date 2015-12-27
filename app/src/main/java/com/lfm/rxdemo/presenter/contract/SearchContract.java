package com.lfm.rxdemo.presenter.contract;

import com.lfm.rxdemo.model.Repositories;

import java.util.List;

/**
 * Created by mogwai on 27/12/2015.
 */
public interface SearchContract {

    void showResults(List<Repositories> repositoriesList);
}
