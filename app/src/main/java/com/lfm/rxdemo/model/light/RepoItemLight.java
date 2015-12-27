package com.lfm.rxdemo.model.light;

import com.lfm.rxdemo.model.Repositories;
import com.lfm.rxdemo.model.User;

/**
 * Created by mogwai on 27/12/2015.
 */
public class RepoItemLight {
    private final String repoName;
    private final String repoUrl;
    private final String ownerImage;
    private final String owerName;

    public RepoItemLight(Repositories repositories) {
        this.repoName = repositories.getName();
        this.repoUrl = repositories.getUrl();
        User owner = repositories.getOwner();
        this.ownerImage = owner.getAvatarUrl();
        this.owerName = owner.getLogin();
    }

    public String getRepoName() {
        return repoName;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public String getOwnerImage() {
        return ownerImage;
    }

    public String getOwerName() {
        return owerName;
    }
}
