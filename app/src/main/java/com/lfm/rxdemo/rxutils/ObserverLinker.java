package com.lfm.rxdemo.rxutils;


import java.util.LinkedList;

import rx.Subscription;

/**
 * Created by mogwai on 27/12/2015.
 */
public class ObserverLinker {
    private LinkedList<Subscription> subscriptions = new LinkedList<>();

    public void link(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public void unlink() {
        for (Subscription subscription : subscriptions) {
            subscription.unsubscribe();
        }
        subscriptions.clear();
    }
}
