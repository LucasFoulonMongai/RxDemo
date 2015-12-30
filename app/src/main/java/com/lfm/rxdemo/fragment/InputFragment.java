package com.lfm.rxdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.lfm.rxdemo.R;
import com.lfm.rxdemo.presenter.InputPresenter;
import com.lfm.rxdemo.presenter.contract.InputContract;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InputFragment extends Fragment implements InputContract {

    @Bind(R.id.input_edit)
    EditText searchEdit;

    private InputPresenter inputPresenter;

    public InputFragment() {
    }

    public static InputFragment newInstance() {
        return new InputFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inputPresenter = new InputPresenter(this);
    }

    @OnClick(R.id.input_button)
    protected void searchButtonClick() {
        inputPresenter.search(searchEdit.getText().toString());
    }

    @Override
    public void onDestroyView() {
        if (inputPresenter != null) {
            inputPresenter.unlink();
        }
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

}
