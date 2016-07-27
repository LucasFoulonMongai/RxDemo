package com.lfm.rxdemo.rx;

import android.support.v7.app.AppCompatActivity;

public class PresenterActivity<T extends Presenter> extends AppCompatActivity {

    private T presenter;

    protected void setPresenter(T presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.start();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.resume();
        }
    }

    @Override
    protected void onPause() {
        if (presenter != null) {
            presenter.pause();
        }
        super.onPause();
    }

    @Override
    protected void onStop() {
        if (presenter != null) {
            presenter.stop();
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.destroy();
        }
        super.onDestroy();
    }
}
