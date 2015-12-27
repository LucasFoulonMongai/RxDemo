package com.lfm.rxdemo.model.light;

import com.lfm.rxdemo.model.Repository;
import com.lfm.rxdemo.model.User;

/**
 * Created by mogwai on 27/12/2015.
 */
public class RepoItemLight {
    private final Integer repoId;
    private final String repoName;
    private final String repoUrl;
    private final String ownerImage;
    private final String owerName;

    public RepoItemLight(Repository repository) {
        this.repoId = repository.getId();
        this.repoName = repository.getName();
        this.repoUrl = repository.getUrl();
        User owner = repository.getOwner();
        this.ownerImage = owner.getAvatarUrl();
        this.owerName = owner.getLogin();
    }

    public Integer getRepoId() {
        return repoId;
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
