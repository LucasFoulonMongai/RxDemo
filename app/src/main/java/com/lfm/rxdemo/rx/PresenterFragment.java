package com.lfm.rxdemo.rx;

import android.support.v4.app.Fragment;

public class PresenterFragment<T extends Presenter> extends Fragment {

    private T presenter;

    public T getPresenter() {
        return presenter;
    }

    protected void setPresenter(T presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.start();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.resume();
        }
    }

    @Override
    public void onPause() {
        if (presenter != null) {
            presenter.pause();
        }
        super.onPause();
    }

    @Override
    public void onStop() {
        if (presenter != null) {
            presenter.stop();
        }
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        if (presenter != null) {
            presenter.destroy();
        }
        super.onDestroyView();
    }
}
