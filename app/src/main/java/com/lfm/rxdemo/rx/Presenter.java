package com.lfm.rxdemo.rx;


import java.util.LinkedList;

import rx.Subscription;

/**
 * Created by Lucas FOULON-MONGAÏ, github.com/LucasFoulonMongai on 28/02/2016.
 */
public class Presenter {
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

    public void start() {
    }

    public void resume() {
    }

    public void pause() {
    }

    public void stop() {
    }

    public void destroy() {
        unlink();
    }
}
