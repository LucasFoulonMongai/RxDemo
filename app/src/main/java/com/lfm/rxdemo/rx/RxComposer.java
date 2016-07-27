package com.lfm.rxdemo.rx;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Lucas FOULON-MONGAÏ, github.com/LucasFoulonMongai on 28/12/2015.
 */
public class RxComposer {

    public static <T> Observable.Transformer<T, T> subscribe_io() {
        return observable -> observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io());
    }

    public static <T> Observable.Transformer<T, T> subscribe_thread() {
        return observable -> observable
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.newThread());
    }

    public static <T> Observable.Transformer<T, T> io_2_main() {
        return observable -> observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> Observable.Transformer<T, T> thread_2_main() {
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
