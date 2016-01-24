package com.lfm.rxdemo.manager.task;

import android.os.AsyncTask;

import com.lfm.rxdemo.dao.GithubDao;
import com.lfm.rxdemo.model.methods.GetSearchRepo;
import com.lfm.rxdemo.util.AsCallback;

public class SearchAsTask extends AsyncTask<Void, Void, Object> {
    private final GithubDao githubDao;
    private final AsCallback<GetSearchRepo> asCallback;
    private final String search;

    public SearchAsTask(AsCallback<GetSearchRepo> asCallback, GithubDao githubDao, String search) {
        this.asCallback = asCallback;
        this.search = search;
        this.githubDao = githubDao;
    }

    @Override
    protected Object doInBackground(Void... voids) {
        try {
            return githubDao.doOnlineGetSearch(search);
        } catch (Exception e) {
            return e;
        }
    }

    @Override
    protected void onPostExecute(Object result) {
        super.onPostExecute(result);
        if (result instanceof GetSearchRepo) {
            asCallback.onItem((GetSearchRepo) result);
            asCallback.onSuccess();
        } else if (result instanceof Throwable) {
            asCallback.onFail((Throwable) result);
        }
    }
}