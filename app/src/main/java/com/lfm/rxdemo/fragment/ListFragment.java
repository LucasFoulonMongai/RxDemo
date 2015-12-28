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
import com.lfm.rxdemo.presenter.ListPresenter;
import com.lfm.rxdemo.presenter.contract.ListContract;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListFragment extends Fragment implements ListContract {

    @Bind(R.id.search_list)
    RecyclerView searchList;

    private ListPresenter listPresenter;
    private GenericRecyclerAdapter<RepoItemLight> searchAdapter;

    public ListFragment() {
    }

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchAdapter = new GenericRecyclerAdapter<>(getContext(), new ArrayList<>(), ItemRepoPresenter.class);
        searchList.setAdapter(searchAdapter);
        searchList.setLayoutManager(new LinearLayoutManager(getContext()));
        listPresenter = new ListPresenter(this);
    }

    @Override
    public void onDestroyView() {
        if (listPresenter != null) {
            listPresenter.unlink();
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
