package com.lfm.rxdemo.presenter.contract;

import com.lfm.rxdemo.model.light.RepoItemLight;

import java.util.List;

/**
 * Created by mogwai on 27/12/2015.
 */
public interface ListContract {

    void showRepositoryList(List<RepoItemLight> repositoryList);

    void showLoadingView(boolean show);

    void showError(boolean show);
}
