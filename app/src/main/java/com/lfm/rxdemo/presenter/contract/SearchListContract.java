package com.lfm.rxdemo.presenter.contract;

import com.lfm.rxdemo.model.light.RepoItemLight;

import java.util.List;

/**
 * Created by Lucas FOULON-MONGAÏ, github.com/LucasFoulonMongai on 27/12/2015.
 */
public interface SearchListContract {

    void showRepositoryList(List<RepoItemLight> repositoryList);

    void showLoadingView(boolean show);

    void showError(boolean show);
}
