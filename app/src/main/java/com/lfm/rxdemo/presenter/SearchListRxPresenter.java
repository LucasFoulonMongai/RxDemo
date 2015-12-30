package com.lfm.rxdemo.presenter;

import com.lfm.rxdemo.manager.SearchRxManager;
import com.lfm.rxdemo.model.light.RepoItemLight;
import com.lfm.rxdemo.model.methods.GetSearchRepo;
import com.lfm.rxdemo.presenter.contract.SearchListContract;
import com.lfm.rxdemo.rxutils.ObserverLinker;
import com.lfm.rxdemo.rxutils.RxComposer;
import com.lfm.rxdemo.util.Lightener;

import java.util.List;

import rx.Observer;

/**
 * Created by Lucas Foulon on 27/12/2015.
 */
public class SearchListRxPresenter extends ObserverLinker {

    private final SearchListContract viewContract;
    private final SearchRxManager searchRxManager;
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

    public SearchListRxPresenter(SearchListContract viewContract) {
        this.viewContract = viewContract;
        searchRxManager = SearchRxManager.getInstance();

        link(searchRxManager.getSearchField()
                .flatMap(s -> {
                    viewContract.showLoadingView(true);
                    return searchRxManager.getSearch(s).compose(RxComposer.io());
                })
                .map(GetSearchRepo::getRepositories)
                .map(Lightener.repoToLight())
                .compose(RxComposer.io())
                .subscribe(observer));
    }

}
