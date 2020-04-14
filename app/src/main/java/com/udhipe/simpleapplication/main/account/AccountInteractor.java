package com.udhipe.simpleapplication.main.account;

import com.udhipe.simpleapplication.main.MainContract;

import org.json.JSONObject;

public class AccountInteractor implements MainContract.AccountInteractor {
    @Override
    public void getAccountData(String token, Listener<JSONObject> listener) {

    }

    @Override
    public void updateAccountData(String token, String username, String password, int version, Listener<JSONObject> listener) {

    }
}
