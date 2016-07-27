package com.lfm.rxdemo.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;

import com.lfm.rvgenadapter.GenericAdapter;
import com.lfm.rxdemo.R;
import com.lfm.rxdemo.item.RepoItem;
import com.lfm.rxdemo.model.light.RepoItemLight;
import com.lfm.rxdemo.presenter.SearchListPresenter;
import com.lfm.rxdemo.presenter.contract.SearchListContract;
import com.lfm.rxdemo.rx.PresenterFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchListFragment extends PresenterFragment<SearchListPresenter> implements SearchListContract {

    @Bind(R.id.search_list)
    RecyclerView searchList;
    @Bind(R.id.search_progress)
    ProgressBar searchProgress;
    @Bind(R.id.search_error)
    ViewStub searchError;

    private GenericAdapter<RepoItemLight> searchAdapter;

    public SearchListFragment() {
    }

    public static SearchListFragment newInstance() {
        return new SearchListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setPresenter(new SearchListPresenter(this));

        searchAdapter = new GenericAdapter<>(getContext(), new ArrayList<>(), RepoItem.class);
        searchList.setAdapter(searchAdapter);
        searchList.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    @Override
    public void showRepositoryList(List<RepoItemLight> repositoryList) {
        searchAdapter.setItems(repositoryList);
    }

    @Override
    public void showLoadingView(boolean show) {
        searchProgress.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showError(boolean show) {
        searchError.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
