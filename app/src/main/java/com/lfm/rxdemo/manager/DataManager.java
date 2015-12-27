package com.lfm.rxdemo.manager;

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

    private final ApiService apiService;

    private DataManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL_API)
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public Observable<GetSearch> getSearch(String search) {
        return apiService.getSearch(search);
    }

}
