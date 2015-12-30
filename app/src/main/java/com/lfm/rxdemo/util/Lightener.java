package com.lfm.rxdemo.util;

import com.lfm.rxdemo.model.Repository;
import com.lfm.rxdemo.model.light.RepoItemLight;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Func1;

/**
 * Created by Lucas Foulon on 28/12/2015.
 */
public class Lightener {
    public static Func1<List<Repository>, List<RepoItemLight>> repoToLight() {
        return repositories1 -> {
            List<RepoItemLight> repoItemLightList = new ArrayList<>(repositories1.size());
            for (int i = 0, size = repositories1.size(); i < size; i++) {
                repoItemLightList.add(new RepoItemLight(repositories1.get(i)));
            }
            return repoItemLightList;
        };
    }
}
