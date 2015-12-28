package com.lfm.rxdemo.presenter;

import com.lfm.rxdemo.manager.SearchManager;
import com.lfm.rxdemo.model.light.RepoItemLight;
import com.lfm.rxdemo.model.methods.GetSearchRepo;
import com.lfm.rxdemo.presenter.contract.ListContract;
import com.lfm.rxdemo.rxutils.ObserverLinker;
import com.lfm.rxdemo.rxutils.RxComposer;
import com.lfm.rxdemo.util.Lightener;

import java.util.List;

import rx.Observer;

/**
 * Created by mogwai on 27/12/2015.
 */
public class ListPresenter extends ObserverLinker {

    private final ListContract viewContract;
    private final SearchManager searchManager;
    private final Observer<List<RepoItemLight>> observer = new Observer<List<RepoItemLight>>() {
        @Override
        public void onCompleted() {
            viewContract.showError(false);
            viewContract.showLoadingView(false);
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            viewContract.showError(true);
            viewContract.showLoadingView(false);
        }

        @Override
        public void onNext(List<RepoItemLight> repositoryList) {
            viewContract.showRepositoryList(repositoryList);
        }
    };

    public ListPresenter(ListContract viewContract) {
        this.viewContract = viewContract;
        searchManager = SearchManager.getInstance();

        link(searchManager.getSearchField()
                .flatMap(s -> searchManager.getSearch(s).compose(RxComposer.io()))
                .map(GetSearchRepo::getRepositories)
                .map(Lightener.repoToLight())
                .compose(RxComposer.io())
                .subscribe(observer));
    }

}
