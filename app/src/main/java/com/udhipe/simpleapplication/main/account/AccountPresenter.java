package com.udhipe.simpleapplication.main.account;

import com.udhipe.simpleapplication.main.MainContract;

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
    public void getAccountInfo() {

    }

    @Override
    public void start() {
        view.showAccountInfo("Hello, this is page account");
    }
}
