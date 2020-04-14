package com.udhipe.simpleapplication.main.account;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.udhipe.simpleapplication.R;
import com.udhipe.simpleapplication.main.MainContract;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment implements MainContract.AccountView {

    MainContract.AccountPresenter presenter;

    TextView tvAccount;

    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        tvAccount = view.findViewById(R.id.tv_Account);

        return view;
    }

    @Override
    public void openPage(String page) {

    }

    @Override
    public void showInfo(String infoCode) {

    }

    @Override
    public void setPresenter(MainContract.AccountPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showAccountInfo(String info) {
        tvAccount.setText(info);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

}
