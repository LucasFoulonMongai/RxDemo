package com.lfm.rxdemo.manager;

import android.content.Context;

import com.lfm.rxdemo.api.ApiService;
import com.lfm.rxdemo.model.GetSearch;
import com.lfm.rxdemo.util.Constants;

import retrofit.Retrofit;
import rx.Observable;

/**
 * Created by mogwai on 27/12/2015.
 */
public class DataManager {

    private static DataManager instance;

    private final Context context;
    private final ApiService apiService;

    private DataManager(Context context) {
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL_API)
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static DataManager getInstance(Context context) {
        if (instance == null) {
            instance = new DataManager(context);
        }
        return instance;
    }

    public Observable<GetSearch> getSearch(String search) {
        return apiService.getSearch(search);
    }

}
