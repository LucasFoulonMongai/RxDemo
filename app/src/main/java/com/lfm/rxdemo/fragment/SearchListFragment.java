package com.lfm.rxdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lfm.rvgenadapter.GenericRecyclerAdapter;
import com.lfm.rxdemo.R;
import com.lfm.rxdemo.itempresenter.ItemRepoPresenter;
import com.lfm.rxdemo.model.light.RepoItemLight;
import com.lfm.rxdemo.presenter.SearchListRxPresenter;
import com.lfm.rxdemo.presenter.contract.SearchListContract;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchListFragment extends Fragment implements SearchListContract {

    @Bind(R.id.search_list)
    RecyclerView searchList;

    private SearchListRxPresenter searchListRxPresenter;
    private GenericRecyclerAdapter<RepoItemLight> searchAdapter;

    public SearchListFragment() {
    }

    public static SearchListFragment newInstance() {
        return new SearchListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchAdapter = new GenericRecyclerAdapter<>(getContext(), new ArrayList<>(), ItemRepoPresenter.class);
        searchList.setAdapter(searchAdapter);
        searchList.setLayoutManager(new LinearLayoutManager(getContext()));

        searchListRxPresenter = new SearchListRxPresenter(this);
    }

    @Override
    public void onDestroyView() {
        if (searchListRxPresenter != null) {
            searchListRxPresenter.unlink();
        }
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    @Override
    public void showRepositoryList(List<RepoItemLight> repositoryList) {
        searchAdapter.setItems(repositoryList);
    }

    @Override
    public void showLoadingView(boolean show) {

    }

    @Override
    public void showError(boolean show) {

    }
}
