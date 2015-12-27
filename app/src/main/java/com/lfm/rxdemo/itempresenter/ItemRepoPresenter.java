package com.lfm.rxdemo.itempresenter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lfm.rvgenadapter.ItemPresenter;
import com.lfm.rxdemo.R;
import com.lfm.rxdemo.model.Repository;

import butterknife.ButterKnife;

/**
 * Created by mogwai on 27/12/2015.
 */
public class ItemRepoPresenter extends ItemPresenter<Repository> {

    private View view;

    @Override
    public void initViewPresenter(Context context, ViewGroup parent, Bundle params, View.OnClickListener onClickListener) {
        this.view = LayoutInflater.from(context).inflate(R.layout.item_repo, parent, false);
        ButterKnife.bind(this, view);

        view.setOnClickListener(onClickListener);
    }

    @Override
    public View getView() {
        return view;
    }

    @Override
    public void refresh() {
        if (view == null) {
            return;
        }

        Repository data = getData();
        view.setTag(R.id.tag_content, data);
        view.setTag(R.id.tag_position, getPosition());

        if (data != null) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
            return;
        }
    }
}
