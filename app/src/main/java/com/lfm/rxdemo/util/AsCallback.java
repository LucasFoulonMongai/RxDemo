package com.lfm.rxdemo.util;

/**
 * Created by l.foulon on 30/12/15.
 */
public interface AsCallback<T> {

    void onSuccess();

    void onItem(T item);

    void onFail(Throwable throwable);
}
