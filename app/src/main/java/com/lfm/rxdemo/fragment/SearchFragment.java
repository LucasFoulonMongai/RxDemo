package com.lfm.rxdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.lfm.rvgenadapter.GenericRecyclerAdapter;
import com.lfm.rxdemo.R;
import com.lfm.rxdemo.model.light.RepoItemLight;
import com.lfm.rxdemo.presenter.SearchPresenter;
import com.lfm.rxdemo.presenter.contract.SearchContract;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchFragment extends Fragment implements SearchContract {

    @Bind(R.id.search_edit)
    EditText searchEdit;

    private SearchPresenter searchPresenter;
    private GenericRecyclerAdapter<RepoItemLight> searchAdapter;

    public SearchFragment() {
    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchPresenter = new SearchPresenter(this);
    }

    @OnClick(R.id.search_button)
    protected void searchButtonClick() {
        searchPresenter.search(searchEdit.getText().toString());
    }

    @Override
    public void onDestroyView() {
        if (searchPresenter != null) {
            searchPresenter.unlink();
        }
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

}
