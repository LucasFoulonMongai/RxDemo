package com.lfm.rxdemo.rx;

import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by Lucas FOULON-MONGAÏ, github.com/LucasFoulonMongai on 28/02/2016.
 */
public class Rx {
    public static final Action1<Throwable> NO_ERROR = throwable -> {
        throwable.printStackTrace();
    };
    public static final Action0 EMPTY = () -> {
    };

    public static <T> Action1<T> empty() {
        return (T) -> {
        };
    }
}
