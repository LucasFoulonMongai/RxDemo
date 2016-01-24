package com.lfm.rxdemo.presenter;

import com.lfm.rxdemo.manager.SearchAsTsManager;
import com.lfm.rxdemo.model.methods.GetSearchRepo;
import com.lfm.rxdemo.presenter.contract.SearchListContract;
import com.lfm.rxdemo.util.AsCallback;
import com.lfm.rxdemo.util.Lightener;

/**
 * Created by Lucas FOULON-MONGAÏ, github.com/LucasFoulonMongai on 27/12/2015.
 */
public class SearchListAsTsPresenter {

    private final SearchListContract viewContract;
    private final SearchAsTsManager searchAsTsManager;
    private final AsCallback<GetSearchRepo> asCallback = new AsCallback<GetSearchRepo>() {
        @Override
        public void onSuccess() {
            viewContract.showError(false);
            viewContract.showLoadingView(false);
        }

        @Override
        public void onItem(GetSearchRepo item) {
            viewContract.showRepositoryList(Lightener.repoToLight().call(item.getRepositories()));
        }

        @Override
        public void onFail(Throwable e) {
            e.printStackTrace();
            viewContract.showError(true);
            viewContract.showLoadingView(false);
        }
    };

    public SearchListAsTsPresenter(SearchListContract viewContract) {
        this.viewContract = viewContract;
        searchAsTsManager = SearchAsTsManager.getInstance();

        searchAsTsManager.getSearch("RxDemo", asCallback);
    }

}
