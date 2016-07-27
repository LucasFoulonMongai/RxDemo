package com.lfm.rxdemo.presenter;

import com.lfm.rxdemo.manager.SearchManager;
import com.lfm.rxdemo.model.Repository;
import com.lfm.rxdemo.model.light.RepoItemLight;
import com.lfm.rxdemo.model.methods.GetSearchRepos;
import com.lfm.rxdemo.presenter.contract.SearchListContract;
import com.lfm.rxdemo.rx.Presenter;
import com.lfm.rxdemo.rx.RxComposer;
import com.lfm.rxdemo.util.Lightener;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Lucas FOULON-MONGAÏ, github.com/LucasFoulonMongai on 27/12/2015.
 */
public class SearchListPresenter extends Presenter {

    private final SearchListContract viewContract;
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

    public SearchListPresenter(SearchListContract viewContract) {
        this.viewContract = viewContract;
        searchManager = SearchManager.getInstance();
    }

    @Override
    public void start() {
        super.start();

        //SIMPLE DEMO
        Subscription subscription1 = searchManager.getSearch("LucasFoulonMongai") // the observable to execute
                .subscribeOn(Schedulers.io()) // the returned observable will be executed the io thread when subscribed
                .unsubscribeOn(Schedulers.io()) // the returned observable will be terminated the io thread when canceled
                .observeOn(AndroidSchedulers.mainThread()) // the returned
                .subscribe(searchRepos -> { // executed when a value is sent from the observable
                    System.out.println("Repos found :");
                    for (Repository repository : searchRepos.getRepositories()) {
                        System.out.println(repository.getName());
                    }
                    System.out.println("----");
                }, throwable -> { // will be executed if an error occur
                    System.out.println("Request failed :");
                    throwable.printStackTrace();
                });

        link(subscription1); // the subscription is the link between the observable and the the observer

        //COMPLETE DEMO
        Subscription subscription2 = searchManager.getSearchFieldSubject()
                //1st step : show the loading when we receive a new search field
                .compose(RxComposer.subscribe_io())
                .doOnNext(searchField -> viewContract.showLoadingView(true)) // 2 - show the loading view
                .observeOn(Schedulers.io())
                .flatMap(searchManager::getSearch) //3 - execute a search request
                .map(GetSearchRepos::getRepositories) //4 - get the repositories
                .map(Lightener.repoToLight()) //5 - transform them to a lighter object
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer); // listen to the result of task through the observer

        link(subscription2);

    }
}
