package com.lfm.rxdemo.itempresenter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lfm.rvgenadapter.ItemPresenter;
import com.lfm.rxdemo.R;
import com.lfm.rxdemo.model.light.RepoItemLight;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mogwai on 27/12/2015.
 */
public class ItemRepoPresenter extends ItemPresenter<RepoItemLight> {

    @Bind(R.id.owner_avatar)
    ImageView ownerAvatar;
    @Bind(R.id.repo_name)
    TextView repoName;
    @Bind(R.id.repo_url)
    TextView repoUrl;
    @Bind(R.id.owner_name)
    TextView ownerName;
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

        RepoItemLight data = getData();
        view.setTag(R.id.tag_content, data);
        view.setTag(R.id.tag_position, getPosition());

        if (data != null) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
            return;
        }
        repoName.setText(data.getRepoName());
        repoUrl.setText(data.getRepoUrl());
        ownerName.setText(data.getOwerName());

    }
}
