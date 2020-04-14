package com.udhipe.simpleapplication.main.account;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.textview.MaterialTextView;
import com.udhipe.simpleapplication.R;
import com.udhipe.simpleapplication.main.MainContract;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment implements MainContract.AccountView {

    MainContract.AccountPresenter presenter;

    MaterialTextView tvUsername;
    MaterialTextView tvKtp;
    MaterialTextView tvEmail;
    MaterialTextView tvPhone;
    MaterialTextView tvAddress;

    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        initializeView(view);

        return view;
    }

    private void initializeView(View view) {
        tvUsername = view.findViewById(R.id.tv_username);
        tvKtp = view.findViewById(R.id.tv_ktp);
        tvEmail = view.findViewById(R.id.tv_email);
        tvPhone = view.findViewById(R.id.tv_phone);
        tvAddress = view.findViewById(R.id.tv_address);
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
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

}
