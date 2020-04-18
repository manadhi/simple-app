package com.udhipe.simpleapplication.main.account;

import com.udhipe.simpleapplication.BaseContract;
import com.udhipe.simpleapplication.main.MainContract;
import com.udhipe.simpleapplication.utility.ConstantManager;

import org.json.JSONObject;

public class AccountPresenter implements MainContract.AccountPresenter {

    MainContract.AccountView view;
    MainContract.AccountInteractor interactor;

    public AccountPresenter(MainContract.AccountView view) {
        this.view = view;
        this.view.setPresenter(this);
        this.interactor = new AccountInteractor();
    }

    @Override
    public void goToPage(String page) {

    }

    @Override
    public void exceptionHandler(String message) {

    }

    @Override
    public void start() {

    }
}
