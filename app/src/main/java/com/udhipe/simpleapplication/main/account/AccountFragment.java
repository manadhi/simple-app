package com.udhipe.simpleapplication.main.account;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textview.MaterialTextView;
import com.udhipe.simpleapplication.R;
import com.udhipe.simpleapplication.detailaccount.DetailAccountActivity;
import com.udhipe.simpleapplication.profile.ProfileActivity;
import com.udhipe.simpleapplication.profile.addprofile.AddProfileActivity;
import com.udhipe.simpleapplication.main.MainContract;
import com.udhipe.simpleapplication.utility.ConstantManager;
import com.udhipe.simpleapplication.model.Preferences;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment implements MainContract.AccountView {

    MaterialButton btnAccountDetail;
    MaterialButton btnProfileDetail;
    MaterialButton btnLogout;

    MainContract.AccountPresenter presenter;

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
        btnAccountDetail = view.findViewById(R.id.btnAccountDetail);
        btnProfileDetail = view.findViewById(R.id.btnProfileDetail);
        btnLogout = view.findViewById(R.id.btnLogout);

        btnAccountDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPage(ConstantManager.ACCOUNT);
            }
        });

        btnProfileDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPage(ConstantManager.PROFILE);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doLogout();
            }
        });
    }

    private void doLogout() {
        Preferences.clearAccountToken(getContext());
        getActivity().finish();
    }

    @Override
    public void openPage(String page) {
        Intent intent = new Intent();
        switch (page) {
            case ConstantManager.PROFILE:
                intent = new Intent(getContext(), ProfileActivity.class);
                break;
            case ConstantManager.ACCOUNT:
                intent = new Intent(getContext(), DetailAccountActivity.class);
                break;
        }

        startActivity(intent);
    }

    @Override
    public void showInfo(String infoCode) {

    }

    @Override
    public void setPresenter(MainContract.AccountPresenter presenter) {
        this.presenter = presenter;
    }

}
