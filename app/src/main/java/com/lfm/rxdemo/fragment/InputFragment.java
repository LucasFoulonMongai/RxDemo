package com.lfm.rxdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.lfm.rxdemo.R;
import com.lfm.rxdemo.presenter.InputPresenter;
import com.lfm.rxdemo.rx.PresenterFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InputFragment extends PresenterFragment<InputPresenter> {

    @Bind(R.id.input_edit)
    EditText searchEdit;

    public InputFragment() {
        //mandatory
    }

    public static InputFragment newInstance() {
        return new InputFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setPresenter(new InputPresenter());
    }

    @OnClick(R.id.input_button)
    protected void searchButtonClick() {
        getPresenter().search(searchEdit.getText().toString());
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

}
