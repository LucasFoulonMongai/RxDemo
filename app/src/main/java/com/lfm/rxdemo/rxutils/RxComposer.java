package com.lfm.rxdemo.rxutils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mogwai on 28/12/2015.
 */
public class RxComposer {
    public static <T> Observable.Transformer<T, T> io() {
        return observable -> observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> Observable.Transformer<T, T> newThread() {
        return observable -> observable
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> Observable.Transformer<T, T> immediate() {
        return observable -> observable
                .subscribeOn(Schedulers.immediate())
                .unsubscribeOn(Schedulers.immediate())
                .observeOn(Schedulers.immediate());
    }

    public static <T> Observable.Transformer<T, T> main() {
        return observable -> observable
                .subscribeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
